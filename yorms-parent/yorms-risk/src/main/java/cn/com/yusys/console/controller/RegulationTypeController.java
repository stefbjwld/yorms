package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dto.RegulationTypeRequest;
import cn.com.yusys.console.po.RegulationType;
import cn.com.yusys.console.service.RegulationTypeService;
import cn.com.yusys.file.util.Constants;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

@RestController
@RequestMapping("/regulationType")
@Api(value = "/regulationType",description = "政策制度分类管理")
public class RegulationTypeController {
	
	private static final Logger log = LoggerFactory.getLogger(RegulationTypeController.class);
	
	@Autowired
	private RegulationTypeService regulationTypeService;
	
	@SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "/add",notes = "添加政策制度分类")
	public OutputData add(@RequestBody RegulationTypeRequest request){
		OutputData out = new OutputData().returnSuccess();
		log.info("添加政策制度分类入参：{}",request.toString());
		RegulationType rt = new RegulationType();
		try{
			try {
//	            BeanUtils.copyProperties(request, rt);
				BeanUtils.copyProperties(rt, request);
            } catch (Exception e) {
            	log.error("请求参数转换异常：{}",e);
            	return out.returnFail(e.getMessage());
            }
			/**参数校验*/
			if(!Constants.TYPETREECODE_W.equals(request.getTypeTreeCode()) && !Constants.TYPETREECODE_N.equals(request.getTypeTreeCode())){
				out.returnFail("政策制度分类一级编码有误!");
				return out;
			}
			if(Constants.TYPETREECODE_W.equals(request.getTypeTreeCode())){
				rt.setTypeTreeCode(Constants.TYPETREECODE_W);
				rt.setTypeTreeName(Constants.TYPETREECODE_W_CN);
			}else if(Constants.TYPETREECODE_N.equals(request.getTypeTreeCode())){
				rt.setTypeTreeCode(Constants.TYPETREECODE_N);
				rt.setTypeTreeName(Constants.TYPETREECODE_N_CN);
			}
			rt.setTypeCode(Constants.getUUID());
			out = regulationTypeService.add(rt);
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
		Map<String,Object> map = new HashMap<String,Object>();
		List<Object> wList = new ArrayList<Object>();
		List<Object> nList = new ArrayList<Object>();
		try{
			List<RegulationType> result = regulationTypeService.queryAll();
			for(RegulationType type: result){
				if(Constants.TYPETREECODE_W.equals(type.getTypeTreeCode())){
					wList.add(type);
				}else{
					nList.add(type);
				}
			}
			map.put(Constants.TYPETREECODE_W, wList);
			map.put(Constants.TYPETREECODE_N, nList);
			out.setData(map);
		}catch(RiskException e){
			log.info("添加政策制度分类服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryTreeAll",method = RequestMethod.GET)
	@ApiOperation(value = "/queryAll",notes = "查询所有政策制度分类")
	public OutputData queryTreeAll(){
		OutputData out = new OutputData().returnSuccess();
		List<Object> list = new ArrayList<Object>();
		List<Object> wList = new ArrayList<Object>();
		List<Object> nList = new ArrayList<Object>();
		
		Map<String,Object> wMap = new HashMap<String,Object>();
		wMap.put("value", Constants.TYPETREECODE_W);
		wMap.put("label", Constants.TYPETREECODE_W);
		
		Map<String,Object> nMap = new HashMap<String,Object>();
		nMap.put("value", Constants.TYPETREECODE_N);
		nMap.put("label", Constants.TYPETREECODE_N);
		
		Map<String,Object> map = null;
		try{
			List<RegulationType> result = regulationTypeService.queryAll();
			for(RegulationType type: result){
				map = new HashMap<String,Object>();
				map.put("id", type.getId());
				map.put("lable", type.getTypeName());
				map.put("value", type.getTypeCode());
				if(Constants.TYPETREECODE_W.equals(type.getTypeTreeCode())){
					wList.add(map);
//					wList.add(type);
				}else{
					nList.add(map);
//					nList.add(type);
				}
			}
			wMap.put("children", wList);
			nMap.put("children", nList);
			list.add(wMap);
			list.add(nMap);
			out.setData(list);
		}catch(RiskException e){
			log.info("添加政策制度分类服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
}
