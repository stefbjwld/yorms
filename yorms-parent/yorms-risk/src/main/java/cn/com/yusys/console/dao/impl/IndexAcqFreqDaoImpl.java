package cn.com.yusys.console.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.dao.IndexAcqFreqDao;
import cn.com.yusys.console.dto.indexAcqFreq.IndexAcqFreqResponse;
import cn.com.yusys.console.po.RiskClassification;

@Repository("IndexAcqFreqDaoImpl2")
public class IndexAcqFreqDaoImpl {
	
	private static final Logger log = LoggerFactory.getLogger(IndexAcqFreqDao.class);
	
	@Autowired
	private EntityManager entityManager;
	
	/**
	 * 风险指标集列表
	 */
	@SuppressWarnings("unchecked")
	public List<IndexAcqFreqResponse> list() {
		List<IndexAcqFreqResponse> result = new ArrayList<IndexAcqFreqResponse>();
		IndexAcqFreqResponse iafr = null;
		StringBuilder sb = new StringBuilder();
		sb.append("select a.id as id,a.risk_classifi_id as riskClassifiId,a.index_en as indexEn,a.index_zh as indexZh,a.index_desc as indexDesc,a.index_acq_freq as indexAcqFreq,a.index_unit as indexUnit,a.index_json as indexJson,e.level1,e.level2,e.level3 from t_index_acq_freq a left join");
		sb.append(" (select a.`name` as level1,a.id as 一级分类ID,b.`name` as level2,b.id as 二级分类ID,c.`name` as level3,c.id as 三级分类ID  from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id");
		sb.append(" left join t_risk_classification c on b.id = c.parent_id");
		sb.append(" where a.parent_id = 0) e on e.三级分类ID = a.risk_classifi_id");
		Query query = entityManager.createNativeQuery(sb.toString());
		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Map<String, Object> map : list) {
				iafr = new IndexAcqFreqResponse();
				iafr.setId((Integer)map.get("id"));
				iafr.setRiskClassifiId((Integer)map.get("riskClassifiId"));
				iafr.setIndexEn(map.get("indexEn").toString());
				iafr.setIndexZh(map.get("indexZh").toString());
				iafr.setIndexDesc(map.get("indexDesc").toString());
				iafr.setIndexAcqFreq(map.get("indexAcqFreq").toString());
				iafr.setIndexUnit(map.get("indexUnit").toString());
				iafr.setIndexJson(map.get("indexJson").toString());
				iafr.setLevel1(map.get("level1").toString());
				iafr.setLevel2(map.get("level2").toString());
				iafr.setLevel3(map.get("level3").toString());
				result.add(iafr);
			}
		}
		return result;
	}
	
	/**
	 * 获取所有的一级风险分类
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public List<RiskClassification> queryLevel1(){
		StringBuilder sb = new StringBuilder();
//		 a.id,a.name,a.parent_id as parentId,a.status
		sb.append("select a.* from t_risk_classification a where a.parent_id = 0 and a.status = 0");
		Query query = entityManager.createNativeQuery(sb.toString(),RiskClassification.class);
		List<RiskClassification> list = query.getResultList();
		if(!list.isEmpty()){
			log.info("一级风险分类条数：{}",list.size());
		}else{
			log.warn("暂无一级风险分类");
		}
		return list;
	}
	
	/**
	 * 根据一级风险分类ID查询二级风险分类信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public List<RiskClassification> queryLevel2(Integer level1Id){
		StringBuilder sb = new StringBuilder();
		sb.append("select b.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id");
		sb.append("	 where a.parent_id = 0 and b.id != 0");
		sb.append("  and b.parent_id = ").append(level1Id);

		Query query = entityManager.createNativeQuery(sb.toString(),RiskClassification.class);
		List<RiskClassification> list = query.getResultList();
		if(!list.isEmpty()){
			log.info("一级风险{}分类下的二级风险分类条数：{}",level1Id,list.size());
		}else{
			log.warn("一级风险{}分类下暂无二级风险分类",level1Id);
		}
		return list;
	}
	
	/**
	 * 根据二级风险分类ID查询三级风险分类信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public List<RiskClassification> queryLevel3(Integer level2Id){
		StringBuilder sb = new StringBuilder();
		sb.append("select b.* from t_risk_classification a left join t_risk_classification b on a.id = b.parent_id");
		sb.append("	 where a.parent_id !=0 and b.id !=0");
		sb.append("  and b.parent_id = ").append(level2Id);

		Query query = entityManager.createNativeQuery(sb.toString(),RiskClassification.class);
		List<RiskClassification> list = query.getResultList();
		if(!list.isEmpty()){
			log.info("二级风险{}分类下的三级风险分类条数：{}",level2Id,list.size());
		}else{
			log.warn("二级风险{}分类下暂无三级风险分类",level2Id);
		}
		return list;
	}
}
