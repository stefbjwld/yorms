package cn.com.yusys.console.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.console.dao.TRiskLevelRepository;
import cn.com.yusys.console.po.TRiskLevel;
import cn.com.yusys.console.service.TRiskLevelService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

@Service
public class TRiskLevelServiceImpl implements TRiskLevelService {
	
	@Autowired
	private TRiskLevelRepository tRiskLevelRepository;
	
	/**
	 * 风险等级信息新增编辑
	 */
	@SuppressWarnings("rawtypes")
    @Override
	public OutputData add(TRiskLevel tl) throws RiskException {
		OutputData out = new OutputData().returnSuccess();
		if(tl.getId()>0){
			TRiskLevel tRiskLevel = tRiskLevelRepository.getOne(tl.getId());
			if(tRiskLevel==null){
				return out.returnFail("主键="+tl.getId()+"的风险等级信息不存在!");
			}
			tRiskLevelRepository.saveAndFlush(tl);
		}else{
			/**判断id是否存在，id不存在为新增，id存在为更新*/
			List<TRiskLevel> list = tRiskLevelRepository.queryByLevelNoAndLevelName(tl.getLevelNo(), tl.getLevelName());
			if(list.isEmpty()){
				tRiskLevelRepository.saveAndFlush(tl);
			}else{
				out.returnFail("等级="+tl.getLevelNo()+",等级名称="+tl.getLevelName()+"已经存在");
			}
		}
		
		return out;
	}

	/**
	 * 查询单个风险等级信息
	 */
	@Override
    public TRiskLevel queryById(Integer id) throws RiskException {
	    return tRiskLevelRepository.getOne(id);
    }

}
