package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.IndexAcqFreqDao;
import cn.com.yusys.console.dao.PipetteClassificationDao;
import cn.com.yusys.console.dto.pipette.PipetteResponse;
import cn.com.yusys.console.dto.pipetteTree.Level1;
import cn.com.yusys.console.po.IndexAcqFreq;
import cn.com.yusys.console.po.KpiCurrentValues;
import cn.com.yusys.console.po.Pipette;
import cn.com.yusys.console.po.PipetteClassification;
import cn.com.yusys.console.service.KpiCurrentValuesService;
import cn.com.yusys.console.service.PiPetteService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

@RestController
@RequestMapping("/pipette")
@Api(value = "/pipette",description = "被管对象管理")
public class PipetteController {
	
	private static final Logger log = LoggerFactory.getLogger(PipetteController.class);
	
	@Autowired
	private PiPetteService pipetteService;
	
	@Autowired
	private IndexAcqFreqDao indexAcqFreqDao;
	
	@Autowired
	private PipetteClassificationDao pipetteClassificationDao;
	
	@Autowired
	private KpiCurrentValuesService kpiCurrentValuesService;
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/list",method = RequestMethod.GET)
	@ApiOperation(value = "/list",notes = "被管对象列表")
	public OutputData list(){
		OutputData out = new OutputData().returnSuccess();
		List<PipetteResponse> list = pipetteService.queryAll();
		out.setData(list);
		return out;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ApiOperation(value = "/add",notes = "新增被管对象")
    public OutputData add(@RequestBody Pipette pipette){
		OutputData out = new OutputData().returnSuccess();
		try {
	        pipetteService.save(pipette);
        } catch (RiskException e) {
        	log.error("新增被管对象服务异常：{}",e);
	       out.returnFail(e.getMessage());
        }
		return out;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/queryIndexAcqFreq",method = RequestMethod.GET)
	@ApiOperation(value = "/queryIndexAcqFreq",notes = "查询所有指标列表")
	public OutputData queryIndexAcqFreq(){
		OutputData out = new OutputData().returnSuccess();
		List<IndexAcqFreq> list = indexAcqFreqDao.findAll();
		out.setData(list);
		return out;
	}
	
	@RequestMapping(value = "/getLevel1",method = RequestMethod.GET)
	@ApiOperation(value = "/getLevel1",notes = "查询被管对象所有的一级分类")
	@SuppressWarnings({"unchecked", "rawtypes"})
	public OutputData getLevel1(){
		OutputData out = new OutputData().returnSuccess();
		List<PipetteClassification> list = pipetteClassificationDao.getAllLevel1();
		out.setData(list);
		return out;
	}
	
	@RequestMapping(value = "/getLevel2",method = RequestMethod.GET)
	@ApiOperation(value = "/getLevel2",notes = "查询被管对象所有的一级分类")
	@SuppressWarnings({"unchecked", "rawtypes"})
	public OutputData getLevel2(@ApiParam(name = "level1",value="被管对象的一级分类ID",required = true)@RequestParam(value = "level1", required = true)Integer level1){
		OutputData out = new OutputData().returnSuccess();
		List<PipetteClassification> list = pipetteClassificationDao.getInfoByLevel1(level1);
		out.setData(list);
		return out;
	}
	
	@SuppressWarnings("rawtypes")
    @RequestMapping(value = "/addKpiValues",method = RequestMethod.POST)
	@ApiOperation(value = "/addKpiValues",notes = "给被管对象关联的指标添加指标属性及属性值")
	public OutputData addKpiValue(@Valid @RequestBody KpiCurrentValues kpiCurrentValues){
		OutputData out = new OutputData().returnSuccess();
		try {
	        out = kpiCurrentValuesService.save(kpiCurrentValues);
        } catch (RiskException e) {
	       out.returnFail(e.getMessage());
        }
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryKpiValue",method = RequestMethod.GET)
	@ApiOperation(value = "/queryKpiValue",notes = "查询被管对象下的指标项所有的指标属性及属性值")
	public OutputData queryKpiValue(@ApiParam(name = "objId",value="被管对象的ID",required = true)@RequestParam(value = "objId", required = true)Integer objId,
			@ApiParam(name = "indexAcqFreqId",value="指标项的ID",required = true)@RequestParam(value = "indexAcqFreqId", required = true)Integer indexAcqFreqId){
		OutputData out = new OutputData().returnSuccess();
		List<KpiCurrentValues>  list = kpiCurrentValuesService.queryByObjIdAndIndexAcqFreqId(objId, indexAcqFreqId);
		out.setData(list);
		return out;
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/queryTree",method = RequestMethod.GET)
	@ApiOperation(value = "/queryTree",notes = "查询被管对象指标树")
	public OutputData queryTree(){
		OutputData out = new OutputData().returnSuccess();
		List<Level1> list = pipetteService.queryTree();
		out.setData(list);
		return out;
	}
}
