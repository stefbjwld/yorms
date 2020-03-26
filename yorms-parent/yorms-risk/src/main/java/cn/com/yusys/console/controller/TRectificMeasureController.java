package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.TRectificMeasureRepository;
import cn.com.yusys.console.dto.rectificMeasure.AddRectificMeasureRequest;
import cn.com.yusys.console.dto.rectificMeasure.QueryTRectificMeasureRequest;
import cn.com.yusys.console.dto.rectificMeasure.UpdateRectificMeasureRequest;
import cn.com.yusys.console.po.TRectificMeasure;
import cn.com.yusys.console.service.TRectificMeasureService;
import cn.com.yusys.file.util.ApiReturnUtil;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.Page;
import cn.com.yusys.file.util.PageUtil;
import cn.com.yusys.file.util.RiskException;

/**
 * 整改措施
 * @author meisw 2020-03-05
 */
@RestController
@RequestMapping("/tRectificMeasure")
@Api(value = "/tRectificMeasure",description = "整改措施")
public class TRectificMeasureController {
	
	@Autowired
	private TRectificMeasureRepository tRectificMeasureRepository;
	@Autowired
	private TRectificMeasureService tRectificMeasureService;
	
	/**
	 * 新增或编辑
	 *//*
	@PostMapping("/save")
	@ApiOperation(value = "/save",notes = "新增或编辑")
	public Object save(@RequestBody TRectificMeasure tRectificMeasure) {
		return tRectificMeasureRepository.save(tRectificMeasure);
	}*/
	
	/**
	 * 新增或编辑
	 */
	@SuppressWarnings("rawtypes")
    @PostMapping("/add")
	@ApiOperation(value = "/add",notes = "新增")
	public OutputData add(@Valid @RequestBody AddRectificMeasureRequest request) {
		OutputData out = new OutputData().returnSuccess();
		TRectificMeasure tRectificMeasure = new TRectificMeasure();
		BeanUtils.copyProperties(request, tRectificMeasure);
		tRectificMeasureRepository.save(tRectificMeasure);
		return out;
	}
	@SuppressWarnings("rawtypes")
    @PostMapping("/update")
	@ApiOperation(value = "/update",notes = "编辑")
	public OutputData update(@Valid @RequestBody UpdateRectificMeasureRequest request) {
		OutputData out = new OutputData().returnSuccess();
		TRectificMeasure tRectificMeasure = new TRectificMeasure();
		BeanUtils.copyProperties(request, tRectificMeasure);
		TRectificMeasure tr = tRectificMeasureRepository.findById(request.getId()).get();
		if(tr == null){
			out.returnFail("没有找到该对象");
		}else{
			tRectificMeasureRepository.save(tRectificMeasure);
		}
		return out;
	}
	
	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation(value = "/delete",notes = "/删除")
	public Object delete(@ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		Optional<TRectificMeasure> tRectificMeasure = tRectificMeasureRepository.findById(id);
		if (tRectificMeasure.isPresent()) {
			tRectificMeasureRepository.deleteById(id);
			return ApiReturnUtil.success("删除成功");
		} else {
			return ApiReturnUtil.error("没有找到该对象");
		}
	}
	
	/**
	 * 查询
	 */
	@PostMapping("/find")
	@ApiOperation(value = "/find",notes = "根据ID查询整改措施")
	public Object find(@Valid @ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		Optional<TRectificMeasure> tRectificMeasure = tRectificMeasureRepository.findById(id);
		if (tRectificMeasure.isPresent()) {
			return ApiReturnUtil.success(tRectificMeasure.get());
		} else {
			return ApiReturnUtil.error("没有找到该对象");
		}
	}
	
	/**
	 * 分页查询
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
    @PostMapping("/list")
	@ApiOperation(value = "/list",notes = "分页查询整改措施")
	public OutputData list(@Valid @RequestBody QueryTRectificMeasureRequest request, @RequestParam(required = false, defaultValue = "0") int pageNumber,
	        @RequestParam(required = false, defaultValue = "10") int pageSize) {
		OutputData out = new OutputData().returnSuccess();
		TRectificMeasure tm = new TRectificMeasure();
		BeanUtils.copyProperties(request, tm);
		List<TRectificMeasure> list = tRectificMeasureService.queryByOption(tm);
		Page<TRectificMeasure> page = PageUtil.startPages(list, pageNumber, pageSize);
		out.setData(page);
		return out;
	}
	
}
