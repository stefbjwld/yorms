package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.TRiskLevel;

/**
*  风险等级信息表
* @author meisw 2020-03-14
*/
@Repository
public interface TRiskLevelRepository extends JpaRepository<TRiskLevel,Integer> {

	@Query(value = "select * from t_risk_level where level_no = :levelNo and level_name = :levelName",nativeQuery = true)
	public List<TRiskLevel> queryByLevelNoAndLevelName(int levelNo,String levelName);
}
