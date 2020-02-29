package cn.com.yusys.console.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.RegulationType;

@Repository
public interface RegulationTypeDao extends JpaRepository<RegulationType, Long> {
	
	@Query(value = "select * from t_regulation_type where type_tree_code = :treeCode and type_name = :typeName",nativeQuery = true)
	public List<RegulationType> queryByTypeTreeCodeAndTypeName(String treeCode,String typeName);
}
