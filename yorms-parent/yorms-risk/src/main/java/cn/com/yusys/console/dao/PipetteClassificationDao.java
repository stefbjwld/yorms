package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.PipetteClassification;

@Repository
public interface PipetteClassificationDao extends JpaRepository<PipetteClassification, Integer>{
	
	/**
	 * 通过被管对象分类二级分类的id查询一级和二级的名称，通过‘-’连接
	 * @param id 二级分类ID
	 * @return
	 */
	@Query(value = "select concat(b.name,'-',a.name) as name from t_pipette_classification a"+
			" left join t_pipette_classification b on a.parent_id = b.id where a.id = :id",nativeQuery = true)
	public String getClassName(Integer id);
	
	/**
	 * 查询被管对象所有一级分类信息
	 * @return
	 */
	@Query(value = "select * from t_pipette_classification where parent_id = 0",nativeQuery = true)
	public List<PipetteClassification> getAllLevel1();
	
	@Query(value = "select * from t_pipette_classification where parent_id = :levelId",nativeQuery = true)
	public List<PipetteClassification> getInfoByLevel1(Integer levelId);
	
}
