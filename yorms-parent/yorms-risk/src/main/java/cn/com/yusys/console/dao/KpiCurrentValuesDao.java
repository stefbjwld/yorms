package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.KpiCurrentValues;

@Repository
public interface KpiCurrentValuesDao extends JpaRepository<KpiCurrentValues, Integer>{
	
	@Query(value = "select * from t_kpi_current_value where object_id = :objId and risk_kpi_id = :indexAcqFreqId and risk_kpi_name = :kpiName",nativeQuery = true)
	public List<KpiCurrentValues> queryByObjIdAndName(Integer objId,Integer indexAcqFreqId,String kpiName);
	
	@Query(value = "select * from t_kpi_current_value where object_id = :objId and risk_kpi_id = :indexAcqFreqId",nativeQuery = true)
	public List<KpiCurrentValues> queryByObjIdAndIndexAcqFreqId(Integer objId,Integer indexAcqFreqId);
}
