package cn.com.yusys.console.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import cn.com.yusys.console.po.TRectificMeasure;


/**
*  整改措施
* @author meisw 2020-03-05
*/
@Repository
public interface TRectificMeasureRepository extends JpaRepository<TRectificMeasure,Integer> ,JpaSpecificationExecutor<TRectificMeasure>{

}