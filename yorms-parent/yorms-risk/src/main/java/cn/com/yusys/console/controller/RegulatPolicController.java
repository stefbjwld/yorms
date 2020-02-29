package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dto.RegulatPolicRequest;
import cn.com.yusys.console.po.RegulatPolic;
import cn.com.yusys.console.service.RegulatPolicService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

/**
 * 政策制度管理
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/regulatPolic")
@Api(value = "/regulatPolic",description = "政策制度管理")
public class RegulatPolicController {
	
	private static final Logger log = LoggerFactory.getLogger(RegulatPolicController.class);
	
	@Autowired
	private RegulatPolicService regulatPolicService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "/add",notes = "添加政策制度管理")
    public OutputData addRegulatPolic(@RequestBody RegulatPolicRequest request){
		OutputData out = new OutputData().returnSuccess();
		log.info("政策制度新增操作入参：{}",request);
		RegulatPolic rp = new RegulatPolic();
		BeanUtils.copyProperties(request, rp);
		try{
			regulatPolicService.add(rp);
		}catch(RiskException e){
			log.error("政策制度新增操作服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/del",method = RequestMethod.POST)
	@ApiOperation(value = "/del",notes = "删除政策制度管理")
    public OutputData addRegulatPolic(@ApiParam(name = "ids",value="ids,多个id使用','连接",required = true)@RequestParam(value = "ids", required = true)String ids){
		OutputData out = new OutputData().returnSuccess();
		log.info("政策制度删除操作入参：{}",ids);
		try{
			if(!StringUtils.isEmpty(ids)){
				String[] idArry = ids.split(",");
				List<Integer> idsList = new ArrayList<>();
				for(int i =0;i<idArry.length;i++){
					idsList.add(Integer.valueOf(idArry[i]));
				}
				regulatPolicService.delete(idsList);
			}
		}catch(RiskException e){
			log.error("政策制度删除操作服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@RequestMapping(value="/update",method = RequestMethod.POST)
	@ApiOperation(value = "/update",notes = "更新政策制度管理")
	@SuppressWarnings("rawtypes")
    public OutputData update(@RequestBody RegulatPolicRequest request){
		OutputData out = new OutputData().returnSuccess();
		Integer id = request.getId();
		if(id==null){
			return out.returnFail("未选择数据");
		}
		RegulatPolic rp = new RegulatPolic();
		try{
			RegulatPolic regulatPolic = regulatPolicService.queryById(id);
			if(regulatPolic == null){
				return out.returnFail("id="+id+"的数据不存在!");
			}
			BeanUtils.copyProperties(request, rp);
			regulatPolicService.update(rp);
		}catch(RiskException e){
			log.error("正常制度更新服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryByOption",method = RequestMethod.POST)
	@ApiOperation(value = "/queryByOption",notes = "多条件查询政策制度")
	public OutputData queryByOption(@RequestBody RegulatPolicRequest request){
		OutputData out = new OutputData().returnSuccess();
		RegulatPolic rp = new RegulatPolic();
		try{
			BeanUtils.copyProperties(request, rp);
			List<RegulatPolic> result = regulatPolicService.queryByRegulatPolic(rp);
			out.setData(result);
		}catch(RiskException e){
			log.error("多條件查詢政策制度服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
    @RequestMapping(value = "/queryByOptionPage",method = RequestMethod.POST)
	@ApiOperation(value = "/queryByOptionPage",notes = "多条件查询政策制度")
	public OutputData queryByOptionPage(@RequestBody RegulatPolicRequest request,Integer pageSize,Integer pageCount){
		OutputData out = new OutputData().returnSuccess();
		RegulatPolic rp = new RegulatPolic();
		if(pageSize ==null || pageSize<1){
			pageSize = 1;
		}
		if(pageCount == null || pageCount<1){
			pageCount = 10;
		}
		try{
			BeanUtils.copyProperties(request, rp);
			Pageable pageable = new PageRequest(pageSize,pageCount);
			Page<RegulatPolic> page = regulatPolicService.page(rp, pageable);
			out.setData(page);
		}catch(RiskException e){
			log.error("多條件查詢政策制度服务异常：{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
}
