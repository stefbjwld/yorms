package cn.com.yusys.console.service;

import cn.com.yusys.console.po.TRiskLevel;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;


public interface TRiskLevelService {
	
	/**
	 * 风险等级信息新增/更新
	 * @param tl
	 * @throws RiskException
	 */
    @SuppressWarnings("rawtypes")
    public OutputData add(TRiskLevel tl)throws RiskException;
    
    /**
     * 根据主键查询详情
     * @param id
     * @return
     * @throws RiskException
     */
    public TRiskLevel queryById(Integer id) throws RiskException;
    
}
