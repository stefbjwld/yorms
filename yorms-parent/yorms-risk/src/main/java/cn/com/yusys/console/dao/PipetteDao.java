package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.Pipette;

@Repository
public interface PipetteDao extends JpaRepository<Pipette, Integer>{
	
	@Query(value = "select * from t_pipette where obj_class = :level2Id",nativeQuery = true)
	List<Pipette> queryByLevel2(Integer level2Id);
}
