package cn.com.yusys.console.service.imp;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import cn.com.yusys.console.dao.TQuestionBankRepository;
import cn.com.yusys.console.po.TQuestionBank;
import cn.com.yusys.console.service.TQuestionBankService;
import cn.com.yusys.file.util.RiskException;

@Service
public class TQuestionBankServiceImpl implements TQuestionBankService {
	
	@Autowired
	private TQuestionBankRepository dao;
	
	@Override
	public List<TQuestionBank> queryByOption(TQuestionBank tb) throws RiskException {
		Specification<TQuestionBank> querySpeci = new Specification<TQuestionBank>(){
			@Override
            public Predicate toPredicate(Root<TQuestionBank> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				/**google list*/
				List<Predicate> predicates = Lists.newArrayList();
	            if(StringUtils.isNotEmpty(tb.getRectificId())){
	            	predicates.add(cb.equal(root.get("rectificId"), tb.getRectificId()));//完全匹配
	            }
	            if(tb.getRectificMeasureId()>0){
	            	predicates.add(cb.equal(root.get("rectificMeasureId"), tb.getRectificMeasureId()));//完全匹配
	            }
	            if(tb.getQuestionType()>0){
	            	predicates.add(cb.equal(root.get("questionType"), tb.getQuestionType()));//完全匹配
	            }
	            if(StringUtils.isNotEmpty(tb.getDescription())){
	            	predicates.add(cb.equal(root.get("description"), "%"+tb.getRectificId()+"%"));//模糊匹配
	            }
	            if(StringUtils.isNotEmpty(tb.getDiscoveryMode())){
	            	predicates.add(cb.equal(root.get("discoveryMode"), tb.getDiscoveryMode()));
	            }
	            if(StringUtils.isNotEmpty(tb.getCauseAnalysis())){
	            	predicates.add(cb.equal(root.get("causeAnalysis"), tb.getCauseAnalysis()));
	            }
	            if(StringUtils.isNotEmpty(tb.getQuestionName())){
	            	predicates.add(cb.equal(root.get("questionName"), "%"+tb.getQuestionName()+"%"));//模糊匹配
	            }
	            if(StringUtils.isNotEmpty(tb.getQuestionNo())){
	            	predicates.add(cb.equal(root.get("questionNo"), tb.getQuestionNo()));//模糊匹配
	            }
	            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
			
		};
		return dao.findAll(querySpeci);
	}
	
}
