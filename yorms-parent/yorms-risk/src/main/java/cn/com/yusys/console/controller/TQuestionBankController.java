package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.TQuestionBankRepository;
import cn.com.yusys.console.po.TQuestionBank;
import cn.com.yusys.file.util.ApiReturnUtil;

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
	
	/**
	 * 新增或编辑
	 */
	@PostMapping("/save")
	@ApiOperation(value = "/save",notes = "新增或者编辑问题表")
	public Object save(@RequestBody  TQuestionBank tQuestionBank) {
		return tQuestionBankRepository.save(tQuestionBank);
	}
	
	/**
	 * 删除
	 */
	@PostMapping("/delete")
	@ApiOperation(value = "delete",notes = "删除此问题")
	public Object delete(@ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		Optional<TQuestionBank> tQuestionBank = tQuestionBankRepository.findById(id);
		if (tQuestionBank.isPresent()) {
			tQuestionBankRepository.deleteById(id);
			return ApiReturnUtil.success("删除成功");
		} else {
			return ApiReturnUtil.error("没有找到该对象");
		}
	}
	
	/**
	 * 查询
	 */
	@PostMapping("/find")
	@ApiOperation(value = "find",notes = "根据ID查询问题")
	public Object find(@ApiParam(name = "id",value = "id",required = true)@RequestParam(value = "id",required = true)int id) {
		Optional<TQuestionBank> tQuestionBank = tQuestionBankRepository.findById(id);
		if (tQuestionBank.isPresent()) {
			return ApiReturnUtil.success(tQuestionBank.get());
		} else {
			return ApiReturnUtil.error("没有找到该对象");
		}
	}
	
	/**
	 * 分页查询
	 */
	@PostMapping("/list")
	@ApiOperation(value = "/list",notes = "分页查询")
	public Object list(@RequestBody TQuestionBank tQuestionBank, @RequestParam(required = false, defaultValue = "0") int pageNumber,
	        @RequestParam(required = false, defaultValue = "10") int pageSize) {
		
		// 创建匹配器，需要查询条件请修改此处代码
		ExampleMatcher matcher = ExampleMatcher.matchingAll();
		
		// 创建实例
		Example<TQuestionBank> example = Example.of(tQuestionBank, matcher);
		// 分页构造
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		return tQuestionBankRepository.findAll(example, pageable);
	}
	
}
