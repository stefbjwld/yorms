package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.po.RegulationType;
import cn.com.yusys.console.service.RegulationTypeService;
import cn.com.yusys.console.util.OutputData;
import cn.com.yusys.console.util.RiskException;

@RestController
@RequestMapping("/regulationType")
@Api(value = "/regulationType",description = "政策制度分类管理")
public class RegulationTypeController {
	
	private static final Logger log = LoggerFactory.getLogger(RegulationTypeController.class);
	
	@Autowired
	private RegulationTypeService RegulationTypeService;
	
	@SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "/add",notes = "添加政策制度分类")
	public OutputData add(@RequestBody RegulationType rt){
		OutputData out = new OutputData().returnSuccess();
		log.info("添加政策制度分类入参：{}",rt.toString());
		try{
			RegulationTypeService.add(rt);
		}catch(RiskException e){
			log.info("添加政策制度分类服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
	@ApiOperation(value = "/queryAll",notes = "查询所有政策制度分类")
	public OutputData queryAll(){
		OutputData out = new OutputData().returnSuccess();
		try{
			List<RegulationType> result = RegulationTypeService.queryAll();
			out.setData(result);
		}catch(RiskException e){
			log.info("添加政策制度分类服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
}
