package cn.com.yusys.console.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.TQuestionBank;

/**
*  问题表
* @author meisw 2020-03-05
*/
@Repository
public interface TQuestionBankRepository extends JpaRepository<TQuestionBank,Integer> ,JpaSpecificationExecutor<TQuestionBank>{
	
	
}