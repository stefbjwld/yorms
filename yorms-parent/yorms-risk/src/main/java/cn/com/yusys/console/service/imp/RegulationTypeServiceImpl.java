package cn.com.yusys.console.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.console.dao.RegulationTypeDao;
import cn.com.yusys.console.po.RegulationType;
import cn.com.yusys.console.service.RegulationTypeService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;


@Service
public class RegulationTypeServiceImpl implements RegulationTypeService {
	
	@Autowired
	private RegulationTypeDao regulationTypeDao;
	
	@SuppressWarnings("rawtypes")
    @Override
	public OutputData add(RegulationType rt) throws RiskException {
		OutputData out = new OutputData().returnSuccess();
		/**判断二级分类名称是否存在,区分一级分类*/
		List<RegulationType> list = regulationTypeDao.queryByTypeTreeCodeAndTypeName(rt.getTypeTreeCode(), rt.getTypeName());
		if(list.isEmpty()){
			regulationTypeDao.saveAndFlush(rt);
		}else{
			out.returnFail("二级分类名称已经存在!");
		}
		return out;
	}
	
	@Override
	public List<RegulationType> queryAll() throws RiskException {
		return regulationTypeDao.findAll();
	}
}
