package cn.com.yusys.console.service;

import java.util.List;

import cn.com.yusys.console.dto.pipette.PipetteResponse;
import cn.com.yusys.console.dto.pipetteTree.Level1;
import cn.com.yusys.console.po.Pipette;
import cn.com.yusys.file.util.RiskException;


public interface PiPetteService {
	
	/**
	 * 查询被管对象列表及关联的指标名称
	 * @return
	 */
	public List<PipetteResponse> queryAll();
	
	/**
	 * 新增被管对象
	 * @param pipette
	 * @throws RiskException
	 */
	public void save(Pipette pipette)throws RiskException;
	
	/**
	 * 获取被管对象树
	 * @return
	 */
	public List<Level1> queryTree();
}
