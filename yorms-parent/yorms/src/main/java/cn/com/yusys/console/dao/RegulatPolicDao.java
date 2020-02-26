package cn.com.yusys.console.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.RegulatPolic;

@Repository
public interface RegulatPolicDao extends JpaRepository<RegulatPolic, Long> ,JpaSpecificationExecutor<RegulatPolic>{
	
	@Modifying
	@Transactional
	@Query(value = "delete from t_regulation_polic where id in(?1)",nativeQuery = true)
	public void deleteBatch(List<Integer> ids);
	
	@Query(value = "select * from t_regulation_polic where id = (?1)",nativeQuery = true)
	public RegulatPolic getById(int id);

}
