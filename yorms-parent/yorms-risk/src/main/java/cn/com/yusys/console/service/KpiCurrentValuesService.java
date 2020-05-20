package cn.com.yusys.console.service;

import java.util.List;

import cn.com.yusys.console.po.KpiCurrentValues;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;


public interface KpiCurrentValuesService {
	
	/**
	 * 给被管对象关联的指标添加指标属性及属性值
	 * @param KpiCurrentValues
	 * @throws RiskException
	 */
	@SuppressWarnings("rawtypes")
    public OutputData save(KpiCurrentValues kpiCurrentValues)throws RiskException;
	
	/**
	 * 查询被管对象下的指标项所有的指标属性信息
	 * @param objId
	 * @param indexAcqFreqId
	 * @return
	 */
	public List<KpiCurrentValues> queryByObjIdAndIndexAcqFreqId(Integer objId,Integer indexAcqFreqId);
}
