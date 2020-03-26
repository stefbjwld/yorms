package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.TQuestionBankRepository;
import cn.com.yusys.console.dto.questionBank.AddQuestionBankRequest;
import cn.com.yusys.console.dto.questionBank.QueryQuestionBankRequest;
import cn.com.yusys.console.dto.questionBank.UpdateQuestionBankRequest;
import cn.com.yusys.console.po.TQuestionBank;
import cn.com.yusys.console.service.TQuestionBankService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.Page;
import cn.com.yusys.file.util.PageUtil;

/**
 * 问题表
 * @author meisw 2020-03-05
 */
@RestController
@RequestMapping("/tQuestionBank")
@Api(value = "/tQuestionBank",description = "问题表")
public class TQuestionBankController {
	
	@Autowired
	private TQuestionBankRepository tQuestionBankRepository;
	
	@Autowired
	private TQuestionBankService qQuestionBankService;
	
	@ApiOperation(value = "/add",notes = "新增问题")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/add",method = RequestMethod.POST)
    public OutputData add(@Valid @RequestBody AddQuestionBankRequest request
//    		@Valid @ApiParam(name = "rectificId", value = "整改序号", required = true )@RequestParam(value = "rectificId",required = true)String rectificId,
//    		@Valid @ApiParam(name = "questionType", value = "问题分类", required = true)@RequestParam(value = "questionType",required = true)Integer questionType,
//    		@Valid @ApiParam(name = "description", value = "问题描述", required = true )@RequestParam(value = "description",required = true)String description,
//    		@Valid @ApiParam(name = "rectificMeasureId", value = "整改措施id", required = true)@RequestParam(value = "rectificMeasureId",required = true)Integer rectificMeasureId,
//    		@Valid @ApiParam(name = "discoveryMode", value = "发现方式", required = true )@RequestParam(value = "discoveryMode",required = true)String discoveryMode,
//    		@Valid @ApiParam(name = "causeAnalysis", value = "原因分析", required = true )@RequestParam(value = "causeAnalysis",required = true)String causeAnalysis,
//    		@Valid @ApiParam(name = "questionName", value = "问题名称", required = true )@RequestParam(value = "questionName",required = true)String questionName,
//    		@Valid @ApiParam(name = "questionNo", value = "问题编号", required = true)@RequestParam(value = "questionNo",required = true)String questionNo
    		){
		OutputData out = new OutputData().returnSuccess();
		TQuestionBank tQuestionBank = new TQuestionBank();
		try{
			BeanUtils.copyProperties(request, tQuestionBank);
//			TQuestionBank tb = new TQuestionBank();
//			tb.setRectificId(rectificId);
//			tb.setQuestionType(questionType);
//			tb.setDescription(description);
//			tb.setRectificMeasureId(rectificMeasureId);
//			tb.setDiscoveryMode(discoveryMode);
//			tb.setCauseAnalysis(causeAnalysis);
//			tb.setQuestionName(questionName);
//			tb.setQuestionNo(questionNo);
			tQuestionBankRepository.save(tQuestionBank);
		}catch(Exception e){
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	@ApiOperation(value = "/update",notes = "编辑问题")
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@SuppressWarnings("rawtypes")
    public OutputData update(@Valid @RequestBody UpdateQuestionBankRequest request
//    		@Valid @ApiParam(name = "id", value = "主键", required = true)@RequestParam(value = "id",required = true)Integer id,
//    		@Valid @ApiParam(name = "rectificId", value = "整改序号", required = true )@RequestParam(value = "rectificId",required = true)String rectificId,
//    		@Valid @ApiParam(name = "questionType", value = "问题分类", required = true)@RequestParam(value = "questionType",required = true)Integer questionType,
//    		@Valid @ApiParam(name = "description", value = "问题描述", required = true )@RequestParam(value = "description",required = true)String description,
//    		@Valid @ApiParam(name = "rectificMeasureId", value = "整改措施id", required = true)@RequestParam(value = "rectificMeasureId",required = true)Integer rectificMeasureId,
//    		@Valid @ApiParam(name = "discoveryMode", value = "发现方式", required = true )@RequestParam(value = "discoveryMode",required = true)String discoveryMode,
//    		@Valid @ApiParam(name = "causeAnalysis", value = "原因分析", required = true )@RequestParam(value = "causeAnalysis",required = true)String causeAnalysis,
//    		@Valid @ApiParam(name = "questionName", value = "问题名称", required = true )@RequestParam(value = "questionName",required = true)String questionName,
//    		@Valid @ApiParam(name = "questionNo", value = "问题编号", required = true)@RequestParam(value = "questionNo",required = true)String questionNo
    		){
		OutputData out = new OutputData().returnSuccess();
		try{
			TQuestionBank tb = new TQuestionBank();
			BeanUtils.copyProperties(request, tb);
//			tb.setId(id);
//			tb.setRectificId(rectificId);
//			tb.setQuestionType(questionType);
//			tb.setDescription(description);
//			tb.setRectificMeasureId(rectificMeasureId);
//			tb.setDiscoveryMode(discoveryMode);
//			tb.setCauseAnalysis(causeAnalysis);
//			tb.setQuestionName(questionName);
//			tb.setQuestionNo(questionNo);
			TQuestionBank tb2 = tQuestionBankRepository.findById(tb.getId()).get();
			if(tb2 == null){
				return out.returnFail("id="+tb.getId()+"问题列表不存在!");
			}
			tQuestionBankRepository.save(tb);
		}catch(Exception e){
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	/**
	 * 删除
	 */
	@SuppressWarnings("rawtypes")
    @PostMapping("/delete")
	@ApiOperation(value = "delete",notes = "删除此问题")
	public OutputData delete(@ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		Optional<TQuestionBank> tQuestionBank = tQuestionBankRepository.findById(id);
		OutputData out = new OutputData().returnSuccess();
		if (tQuestionBank.isPresent()) {
			tQuestionBankRepository.deleteById(id);
			return out;
		} else {
			return out.returnFail("没有找到该对象");
		}
	}
	
	/**
	 * 查询
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
    @PostMapping("/find")
	@ApiOperation(value = "find",notes = "根据ID查询问题")
	public OutputData find(@ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		OutputData out = new OutputData().returnSuccess();
		Optional<TQuestionBank> tQuestionBank = tQuestionBankRepository.findById(id);
		if (tQuestionBank.isPresent()) {
			out.setData(tQuestionBank.get());
			return out;
		} else {
			return out.returnFail("没有找到该对象");
		}
	}
	
	/**
	 * 分页查询
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
    @PostMapping("/list")
	@ApiOperation(value = "/list",notes = "分页查询")
	public Object list(
			@Valid @RequestBody QueryQuestionBankRequest request, 
//			@ApiParam(name = "id", value = "主键", required = false)@RequestParam(value = "id",required = false)Integer id,
//			@ApiParam(name = "rectificId", value = "整改序号", required = false )@RequestParam(value = "rectificId",required = false)String rectificId,
//			@ApiParam(name = "questionType", value = "问题分类", required = false)@RequestParam(value = "questionType",required = false)Integer questionType,
//			@ApiParam(name = "description", value = "问题描述", required = false )@RequestParam(value = "description",required = false)String description,
//			@ApiParam(name = "rectificMeasureId", value = "整改措施id", required = false)@RequestParam(value = "rectificMeasureId",required = false)Integer rectificMeasureId,
//            @ApiParam(name = "discoveryMode", value = "发现方式", required = false )@RequestParam(value = "discoveryMode",required = false)String discoveryMode,
//            @ApiParam(name = "causeAnalysis", value = "原因分析", required = false )@RequestParam(value = "causeAnalysis",required = false)String causeAnalysis,
//            @ApiParam(name = "questionName", value = "问题名称", required = false )@RequestParam(value = "questionName",required = false)String questionName,
//            @ApiParam(name = "questionNo", value = "问题编号", required = false)@RequestParam(value = "questionNo",required = false)String questionNo,
			@RequestParam(required = false, defaultValue = "0") int pageNumber,
	        @RequestParam(required = false, defaultValue = "10") int pageSize) {
		OutputData out = new OutputData().returnSuccess();
		try{
			TQuestionBank tb = new TQuestionBank();
			BeanUtils.copyProperties(request, tb);
			List<TQuestionBank> list = qQuestionBankService.queryByOption(tb);
			Page<TQuestionBank> page = PageUtil.startPages(list, pageNumber, pageSize);
			out.setData(page);
		}catch(Exception e){
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
}
