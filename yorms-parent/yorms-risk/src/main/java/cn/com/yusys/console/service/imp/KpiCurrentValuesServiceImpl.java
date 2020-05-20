package cn.com.yusys.console.service.imp;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.console.dao.KpiCurrentValuesDao;
import cn.com.yusys.console.po.KpiCurrentValues;
import cn.com.yusys.console.service.KpiCurrentValuesService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

@Service
public class KpiCurrentValuesServiceImpl implements KpiCurrentValuesService {
	
	@Autowired
	private KpiCurrentValuesDao dao;
	
	@SuppressWarnings("rawtypes")
    @Override
	public OutputData save(KpiCurrentValues kpiCurrentValues) throws RiskException {
		String msg = "";
		boolean flag = true;
		OutputData out = new OutputData().returnFail();
		if(kpiCurrentValues == null){
			msg = "入参不能为空";
			flag = false;
		}
		if(kpiCurrentValues.getObjectId()<1){
			msg = "未选中被管对象";
			flag = false;
		}
		if(kpiCurrentValues.getIndexAcqFreqId()<1){
			msg = "未选中指标项";
			flag = false;
		}
		if(StringUtils.isEmpty(kpiCurrentValues.getKpiName())){
			msg = "指标项属性名称不能为空";
			flag = false;
		}
		if(StringUtils.isEmpty(kpiCurrentValues.getKpiValue())){
			msg = "指标项属性值不能为空";
			flag = false;
		}
		if(kpiCurrentValues.getTimestamp()==null){
			kpiCurrentValues.setTimestamp(new Date());
		}
		if(flag){
			List<KpiCurrentValues>  list = dao.queryByObjIdAndName(kpiCurrentValues.getObjectId(), kpiCurrentValues.getIndexAcqFreqId(), kpiCurrentValues.getKpiName());
			if(!list.isEmpty()){
				msg = "该指标项属性名已经存在!";
				flag = false;
			}
		}
		if(flag){
			dao.saveAndFlush(kpiCurrentValues);
			out.returnSuccess(OutputData.SUCCESS_MESSAGE);
		}else{
			out.returnFail(msg);
		}
		return out;
	}

	@Override
    public List<KpiCurrentValues> queryByObjIdAndIndexAcqFreqId(Integer objId, Integer indexAcqFreqId) {
	    return dao.queryByObjIdAndIndexAcqFreqId(objId, indexAcqFreqId);
    }
	
}
