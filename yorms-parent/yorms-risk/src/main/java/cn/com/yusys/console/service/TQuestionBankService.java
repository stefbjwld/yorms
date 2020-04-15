package cn.com.yusys.console.service;

import java.util.List;

import cn.com.yusys.console.po.TQuestionBank;
import cn.com.yusys.file.util.RiskException;


public interface TQuestionBankService {
	
	/**
	 * 多条件查询问题列表
	 * @param tb
	 * @return
	 * @throws RiskException
	 */
	public List<TQuestionBank> queryByOption(TQuestionBank tb)throws RiskException;
}
