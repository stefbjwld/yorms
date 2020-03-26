package cn.com.yusys.console.service;

import java.util.List;

import cn.com.yusys.console.po.TRectificMeasure;


public interface TRectificMeasureService {
	
	/**
	 * 多条件查询整改措施
	 * @param tm
	 * @return
	 */
	public List<TRectificMeasure> queryByOption(TRectificMeasure tm);
}
