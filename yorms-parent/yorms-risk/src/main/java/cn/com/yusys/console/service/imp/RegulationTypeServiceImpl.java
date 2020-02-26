package cn.com.yusys.console.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.console.dao.RegulationTypeDao;
import cn.com.yusys.console.po.RegulationType;
import cn.com.yusys.console.service.RegulationTypeService;
import cn.com.yusys.console.util.RiskException;


@Service
public class RegulationTypeServiceImpl implements RegulationTypeService {
	
	@Autowired
	private RegulationTypeDao regulationTypeDao;
	
	@Override
	public void add(RegulationType rt) throws RiskException {
		regulationTypeDao.saveAndFlush(rt);
	}
	
	@Override
	public List<RegulationType> queryAll() throws RiskException {
		return regulationTypeDao.findAll();
	}
}
