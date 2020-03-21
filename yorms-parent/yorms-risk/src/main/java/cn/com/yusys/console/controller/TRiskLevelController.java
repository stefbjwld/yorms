package cn.com.yusys.console.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.console.dao.TRiskLevelRepository;
import cn.com.yusys.console.dto.riskLevel.AddRiskLevelRequest;
import cn.com.yusys.console.dto.riskLevel.UpdateRiskLevelRequest;
import cn.com.yusys.console.po.TRiskLevel;
import cn.com.yusys.console.service.TRiskLevelService;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.file.util.RiskException;

/**
* 风险等级信息表
* @author meisw 2020-03-14
*/
@Api(value = "/tRiskLevel",description = "风险等级信息表")
@RestController
@RequestMapping("/tRiskLevel")
public class TRiskLevelController {

	private static final Logger log = LoggerFactory.getLogger(TRiskLevelController.class);
	
    @Autowired
    private TRiskLevelRepository tRiskLevelRepository;
    
    @Autowired
    private TRiskLevelService tRiskLevelService;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "/add",notes = "风险等级信息添加")
    public OutputData add(@Valid @RequestBody AddRiskLevelRequest request){
    	log.info("风险等级信息添加入参：{}",request);
    	OutputData out = new OutputData().returnFail();
    	TRiskLevel tl = new TRiskLevel();
    	try{
    		BeanUtils.copyProperties(request, tl);
        	tRiskLevelService.add(tl);
    	}catch(RiskException e){
    		log.error("风险等级信息添加服务异常：{}",e);
    		out.returnFail(e.getMessage());
    	}
    	return out;
    }
    
    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ApiOperation(value = "/update",notes = "风险等级信息编辑")
    public OutputData update(@Valid @RequestBody UpdateRiskLevelRequest request){
    	log.info("风险等级信息修改入参：{}",request);
    	OutputData out = new OutputData().returnFail();
    	TRiskLevel tl = new TRiskLevel();
    	try{
    		BeanUtils.copyProperties(request, tl);
        	tRiskLevelService.add(tl);
    	}catch(RiskException e){
    		log.error("风险等级信息修改服务异常：{}",e);
    		out.returnFail(e.getMessage());
    	}
    	return out;
    }
    
//    /**
//    * 新增或编辑
//    */
//    @PostMapping("/save")
//    @ApiOperation(value = "/save",notes = "新增或者编辑")
//    public Object save(@RequestBody TRiskLevel tRiskLevel){
//    	//先判断一级风险是否存在
//    	
//        return tRiskLevelRepository.save(tRiskLevel);
//    }

    /**
    * 删除
    */
    @SuppressWarnings("rawtypes")
    @PostMapping("/delete")
    @ApiOperation(value = "/delete",notes = "删除")
    public OutputData delete(@ApiParam(name = "id",value="id",required = true)@RequestParam(value = "id", required = true)int id){
    	OutputData out = new OutputData().returnSuccess();
        Optional<TRiskLevel> tRiskLevel=tRiskLevelRepository.findById(id);
        if(tRiskLevel.isPresent()){
            tRiskLevelRepository.deleteById(id);
            return out;
        }else{
            return out.returnFail("没有找到该对象");
        }
    }

    /**
    * 查询
    */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @PostMapping("/find")
    @ApiOperation(value = "/find",notes = "查询")
    public OutputData find(@ApiParam(name = "id",value="id",required = true)@RequestParam(value = "id", required = true)int id){
    	OutputData out = new OutputData().returnSuccess();
        Optional<TRiskLevel> tRiskLevel=tRiskLevelRepository.findById(id);
        if(tRiskLevel.isPresent()){
            out.setData(tRiskLevel.get());
        }else{
            out.setMessage("没有找到该对象");
        }
        return out;
    }

    /**
    * 分页查询
    */
//    @PostMapping("/list")
//    @ApiOperation(value = "/list",notes = "分页查询")
//    public Object list(@RequestBody TRiskLevel tRiskLevel,
//                        @RequestParam(required = false, defaultValue = "0") int pageNumber,
//                        @RequestParam(required = false, defaultValue = "10") int pageSize) {
//
//            //创建匹配器，需要查询条件请修改此处代码
//            ExampleMatcher matcher = ExampleMatcher.matchingAll();
//
//            //创建实例
//            Example<TRiskLevel> example = Example.of(tRiskLevel, matcher);
//            //分页构造
//            Pageable pageable = PageRequest.of(pageNumber,pageSize);
//
//            return tRiskLevelRepository.findAll(example, pageable);
//    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    /**
     * 查询所有
     */
     @PostMapping("/list")
     @ApiOperation(value = "/list",notes = "查询所有")
     public OutputData list() {
    	 OutputData out = new OutputData().returnSuccess();
         List<TRiskLevel> list =  tRiskLevelRepository.findAll();
         out.setData(list); 
         return out;
     }
}
