package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.IndexAcqFreqDao;
import cn.com.yusys.console.dao.impl.IndexAcqFreqDaoImpl;
import cn.com.yusys.console.dto.indexAcqFreq.IndexAcqFreqResponse;
import cn.com.yusys.console.po.IndexAcqFreq;
import cn.com.yusys.console.po.RiskClassification;
import cn.com.yusys.file.util.OutputData;

/**
 * 风险指标集列表
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/IndexAcqFreq")
@Api(value = "/IndexAcqFreq",description = "风险指标集列表")
public class IndexAcqFreqController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexAcqFreqController.class);
	
	@Autowired
	private IndexAcqFreqDaoImpl indexAcqFreqDaoImpl;
	
	@Autowired
	private IndexAcqFreqDao indexAcqFreqDao;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "/add",notes = "风险指标集新增")
	@SuppressWarnings({"rawtypes"})
    public OutputData add(@RequestBody IndexAcqFreq iaf){
		OutputData out = new OutputData().returnSuccess();
		try{
			indexAcqFreqDao.saveAndFlush(iaf);
		}catch(Exception e){
			log.error("新增风险指标失败!{}",e);
			out.returnFail(e.getMessage());
		}
		
		return out;
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	@ApiOperation(value = "/list",notes = "风险指标集列表展示")
	@SuppressWarnings({"unchecked", "rawtypes"})
    public OutputData list(){
		OutputData out = new OutputData().returnSuccess();
		List<IndexAcqFreqResponse> list = indexAcqFreqDaoImpl.list();
		if(!list.isEmpty()){
			log.info("总共{}条风险指标集",list.size());
		}else{
			log.warn("暂无风险指标集数据");
		}
		out.setData(list);
		return out;
	}
	
	@RequestMapping(value = "/level1",method = RequestMethod.GET)
	@ApiOperation(value = "/level1",notes = "查询所有一级风险分类")
	@SuppressWarnings({"unchecked", "rawtypes"})
	public OutputData level1(){
		OutputData out = new OutputData().returnSuccess();
		List<RiskClassification>  list = indexAcqFreqDaoImpl.queryLevel1();
		out.setData(list);
		return out;
	}
	
	@RequestMapping(value = "/level2",method = RequestMethod.GET)
	@ApiOperation(value = "/level2",notes = "根据一级风险分类ID查询二级分类风险")
	@SuppressWarnings({"unchecked", "rawtypes"})
	public OutputData level2(@ApiParam(name = "level1Id",value = "level1Id",required = true)@RequestParam(value = "level1Id",required = true)int level1Id){
		OutputData out = new OutputData().returnSuccess();
		List<RiskClassification>  list = indexAcqFreqDaoImpl.queryLevel2(level1Id);
		out.setData(list);
		return out;
	}
	
	@RequestMapping(value = "/level3",method = RequestMethod.GET)
	@ApiOperation(value = "/level3",notes = "根据二级风险分类ID查询三级分类风险")
	@SuppressWarnings({"unchecked", "rawtypes"})
	public OutputData level3(@ApiParam(name = "level2Id",value = "level2Id",required = true)@RequestParam(value = "level2Id",required = true)int level2Id){
		OutputData out = new OutputData().returnSuccess();
		List<RiskClassification>  list = indexAcqFreqDaoImpl.queryLevel3(level2Id);
		out.setData(list);
		return out;
	}
}
