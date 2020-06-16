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

import cn.com.yusys.console.dao.TRectificMeasureRepository;
import cn.com.yusys.console.po.TRectificMeasure;
import cn.com.yusys.console.service.TRectificMeasureService;

import com.google.common.collect.Lists;

@Service
public class TRectificMeasureServiceImpl implements TRectificMeasureService {
	
	@Autowired
	private TRectificMeasureRepository dao;
	
	@Override
	public List<TRectificMeasure> queryByOption(TRectificMeasure tm) {
		@SuppressWarnings("serial")
        Specification<TRectificMeasure> querySpeci = new Specification<TRectificMeasure>() {
			@Override
			public Predicate toPredicate(Root<TRectificMeasure> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				/** google list */
				List<Predicate> predicates = Lists.newArrayList();
				if (tm.getId() > 0) {
					predicates.add(cb.equal(root.get("id"), tm.getId()));// 完全匹配
				}
				if(tm.getPlanCompletTime()!=null){
					predicates.add(cb.equal(root.get("planComplerTime"), tm.getPlanCompletTime()));
				}
				if (tm.getRectificMeasureId() > 0) {
					predicates.add(cb.equal(root.get("rectificMeasureId"), tm.getRectificMeasureId()));
				}
				if (tm.getRectificDeptId() > 0) {
					predicates.add(cb.equal(root.get("rectificDeptId"), tm.getRectificDeptId()));
				}
				if (StringUtils.isNotEmpty(tm.getRectificDeptName())) {
					predicates.add(cb.equal(root.get("rectificDeptName"), tm.getRectificDeptName()));
				}
				if (StringUtils.isNotEmpty(tm.getRectificLeaderName())) {
					predicates.add(cb.equal(root.get("rectificLeaderName"), tm.getRectificLeaderName()));
				}
				if (StringUtils.isNotEmpty(tm.getRectificCooperatDept())) {
					predicates.add(cb.equal(root.get("rectificCooperatDept"), tm.getRectificCooperatDept()));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return dao.findAll(querySpeci);
	}
	
}
