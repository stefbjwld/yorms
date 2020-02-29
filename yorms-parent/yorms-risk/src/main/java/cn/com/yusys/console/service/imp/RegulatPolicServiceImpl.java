package cn.com.yusys.console.service.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.com.yusys.console.dao.RegulatPolicDao;
import cn.com.yusys.console.po.RegulatPolic;
import cn.com.yusys.console.service.RegulatPolicService;
import cn.com.yusys.file.util.RiskException;
import cn.com.yusys.file.util.TimesUtil;

@Service
public class RegulatPolicServiceImpl implements RegulatPolicService {
	
	private static final Logger log = LoggerFactory.getLogger(RegulatPolic.class);
	
	@Autowired
	private RegulatPolicDao regulatPolicDao;
	
	@Autowired
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(RegulatPolic regulatPolic) throws RiskException {
		regulatPolicDao.saveAndFlush(regulatPolic);
	}
	
	@Override
	@Transactional
	public void update(RegulatPolic regulatPolic) throws RiskException {
		regulatPolicDao.saveAndFlush(regulatPolic);
	}
	
	@Override
	public void delete(List<Integer> ids) throws RiskException {
		regulatPolicDao.deleteBatch(ids);
	}
	
	@SuppressWarnings("unchecked")
    @Override
	public List<RegulatPolic> queryByRegulatPolic(RegulatPolic regulatPolic) throws RiskException {
		List<RegulatPolic> list = new ArrayList<>();
		RegulatPolic rp = null;
		log.info("多条件查询政策法规   start ...");
		StringBuilder sql = new StringBuilder();
		sql.append("select id,regulation_name,regulation_no,grp_id,regulation_type,`status`,dept_no,date from t_regulation_polic where 1 = 1 ");
		if(regulatPolic != null && StringUtils.isNotEmpty(regulatPolic.getRegulationName())){
			sql.append(" and regulation_name like '%").append(regulatPolic).append("%'");
		}
		if(regulatPolic!=null && StringUtils.isNotEmpty(regulatPolic.getRegulationName())){
			sql.append(" and regulation_name = ").append(regulatPolic.getRegulationName());
		}
		if(regulatPolic!=null && regulatPolic.getRegulationType()>0){
			sql.append(" and regulation_type = ").append(regulatPolic.getRegulationType());
		}
		if(regulatPolic!=null && StringUtils.isNotEmpty(regulatPolic.getStatus())){
			sql.append(" and `status` = '").append(regulatPolic.getStatus()).append("'");
		}
		if(regulatPolic!=null && regulatPolic.getGrpId()>0){
			sql.append(" and grp_id = ").append(regulatPolic.getGrpId());
		}
		Query query = em.createNativeQuery(sql.toString());
		List<Object[]> result = query.getResultList();
		if(result !=null && result.size()>0){
			for(int i =0;i<result.size();i++){
				Object[] obj = result.get(i);
				rp = new RegulatPolic();
				rp.setId((Integer)(obj[0]));
				rp.setRegulationName((String)obj[1]);
				rp.setRegulationNo((String)obj[2]);
				rp.setGrpId((Integer)obj[3]);
				rp.setRegulationType((Integer)obj[4]);
				rp.setStatus((String)obj[5]);
				rp.setDeptNo((String)obj[6]);
				rp.setDate(TimesUtil.timestamp2Date((Timestamp)obj[7]));
				list.add(rp);
			}
		}
		log.info("查询结果条数：{}",list.size());
		/*Example<RegulatPolic> example = Example.of(regulatPolic);
		list = regulatPolicDao.findAll(example);*/
		
		/*ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
		Example<RegulatPolic> example = Example.of(regulatPolic,matcher);*/
		return list;
	}

	@Override
    public RegulatPolic queryById(int id) throws RiskException {
		return regulatPolicDao.getById(id);
    }

	@Override
    public Page<RegulatPolic> page(RegulatPolic regulatPolic, Pageable pageable) throws RiskException {
		//CriteriaBuilder,用来构建CritiaQuery的构建器对象 
	    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder(); 
	      
	    //CriteriaQuery,它包含着查询语句的条件各个部分，比如：select 、from、where、group by、order by等 
	    CriteriaQuery<RegulatPolic> criteriaQuery = criteriaBuilder.createQuery(RegulatPolic.class); 
	      
	    //查询根，用于获取查询实例的属性，通过CriteriaQuery的from方法获取 
	    Root<RegulatPolic> rootFrom = criteriaQuery.from(RegulatPolic.class); 
	      
	    //查询条件 
	    List<Predicate> predicates = new ArrayList<Predicate>(); 
	    if(regulatPolic != null && StringUtils.isNotEmpty(regulatPolic.getRegulationName())){
//	    	Predicate predicate = criteriaBuilder.equal(rootFrom.get("regulationName").as(String.class), regulatPolic.getRegulationName());
	    	Predicate predicate = criteriaBuilder.like(rootFrom.joinList("%").join("regulationName").join("%"), regulatPolic.getRegulationName());
	    	predicates.add(predicate);
		}
		if(regulatPolic!=null && StringUtils.isNotEmpty(regulatPolic.getRegulationName())){
			Predicate predicate = criteriaBuilder.equal(rootFrom.get("regulationNo").as(String.class), regulatPolic.getRegulationNo());
	    	predicates.add(predicate);
		}
		if(regulatPolic!=null && regulatPolic.getRegulationType()>0){
			Predicate predicate = criteriaBuilder.equal(rootFrom.get("grpId").as(Integer.class), regulatPolic.getGrpId());
	    	predicates.add(predicate);
		}
		if(regulatPolic!=null && StringUtils.isNotEmpty(regulatPolic.getStatus())){
			Predicate predicate = criteriaBuilder.equal(rootFrom.get("regulationType").as(Integer.class), regulatPolic.getRegulationType());
	    	predicates.add(predicate);
		}
		if(regulatPolic!=null && regulatPolic.getGrpId()>0){
			Predicate predicate = criteriaBuilder.equal(rootFrom.get("status").as(Integer.class), regulatPolic.getStatus());
	    	predicates.add(predicate);
		}
	      
	    //格式化参数 
	    criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]))); 
	      
	    //默认按照id排序（从小到大） 
	    criteriaQuery.orderBy(criteriaBuilder.asc(rootFrom.get("id"))); 
	      
	    //SQL查询对象 
	    TypedQuery<RegulatPolic> createQuery = em.createQuery(criteriaQuery); 
	      
	    //分页参数 
	    Integer pageSize = pageable.getPageSize(); 
	    Integer pageNo = pageable.getPageNumber(); 
	      
	    //计数查询结果条数 
	    TypedQuery<RegulatPolic> createCountQuery = em.createQuery(criteriaQuery); 
	      
	    // 实际查询返回分页对象 
	    int startIndex = pageSize * pageNo; 
	    createQuery.setFirstResult(startIndex); 
	    createQuery.setMaxResults(pageable.getPageSize()); 
	    Page<RegulatPolic> pageRst = new PageImpl<RegulatPolic>(createQuery.getResultList(), pageable, createCountQuery.getResultList().size()); 
	    return pageRst; 
    }

}
