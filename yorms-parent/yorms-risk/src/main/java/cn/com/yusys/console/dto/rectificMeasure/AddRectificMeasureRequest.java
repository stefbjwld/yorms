package cn.com.yusys.console.dto.rectificMeasure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "AddRectificMeasureRequest",description = "新增整改措施")
public class AddRectificMeasureRequest {
	 /**
	    * 整改id
	    */
	@ApiModelProperty(value = "整改id")
	    private Integer rectificMeasureId;

	    /**
	    * 计划完成时间
	    */
	@ApiModelProperty(value = "went fenl")
	    private Date planCompletTime;

	    /**
	    * 整改牵头部门名称
	    */
	    private String rectificDeptName;

	    /**
	    * 整改牵头部门id
	    */
	    private Integer rectificDeptId;

	    /**
	    * 整改牵头人
	    */
	    private String rectificLeaderName;

	    /**
	    * 整改配合部门
	    */
	    private String rectificCooperatDept;

	    /**
	    * 整改状态 1：已整改: 2：未整改、3：无法整改: 4：整改中
	    */
	    private String rectificStatus;

	    /**
	    * 整理类型：1：短期，2：长期
	    */
	    private String rectificType;
}
