package cn.com.yusys.console.service;

import java.util.List;

import cn.com.yusys.console.po.RegulationType;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;


public interface RegulationTypeService {
	
	/**
	 * 添加制度
	 * @param rt
	 * @throws RiskException
	 */
	@SuppressWarnings("rawtypes")
    public OutputData add(RegulationType rt) throws RiskException; 
	
	/**
	 * 查詢所有分类
	 * @return
	 * @throws RiskException
	 */
	public List<RegulationType> queryAll() throws RiskException;
}
