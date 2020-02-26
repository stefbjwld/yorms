package cn.com.yusys.console.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.RegulationType;

@Repository
public interface RegulationTypeDao extends JpaRepository<RegulationType, Long> {
	
}
