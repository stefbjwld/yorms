package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.com.yusys.console.po.IndexAcqFreq;

/**
 * 风险指标管理
 * @author Administrator
 *
 */
public interface IndexAcqFreqDao extends JpaRepository<IndexAcqFreq, Integer>{
	
	@Query(value = "select * from t_index_acq_freq where id in (:ids)",nativeQuery = true)
	public List<IndexAcqFreq> findByIds(List<Integer> ids);
	
}
