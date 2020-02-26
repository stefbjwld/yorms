package cn.com.yusys.console.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.com.yusys.console.po.RegulatPolic;
import cn.com.yusys.console.util.RiskException;


public interface RegulatPolicService {
	
	/**
	 * 政策制度添加操作
	 * @param regulatPolic
	 * @throws RiskException
	 */
	public void add(RegulatPolic regulatPolic)throws RiskException;
	
	/**
	 * 政策制度更新操作
	 * @param regulatPolic
	 * @throws RiskException
	 */
	public void update(RegulatPolic regulatPolic)throws RiskException;
	
	/**
	 * 政策制度批量删除操作
	 * @param id
	 * @throws RiskException
	 */
	public void delete(List<Integer> ids)throws RiskException;
	
	/**
	 * 根据主键查询政策制度
	 * @param id
	 * @return
	 * @throws RiskException
	 */
	public RegulatPolic queryById(int id)throws RiskException;
	
	/**
	 * 政策制度条件查询
	 * @param regulatPolic
	 * @return
	 * @throws RiskException
	 */
	public List<RegulatPolic> queryByRegulatPolic(RegulatPolic regulatPolic)throws RiskException;
	
	/**
	 * 多条件查询分页
	 * @param regulatPolic
	 * @param pageable
	 * @return
	 * @throws RiskException
	 */
	public Page<RegulatPolic> page(RegulatPolic regulatPolic,Pageable pageable)throws RiskException;
}
