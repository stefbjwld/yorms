package cn.com.yusys.console.dto.rectificMeasure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "AddRectificMeasureRequest", description = "新增整改措施")
public class AddRectificMeasureRequest {
	
	/**
	 * 整改id
	 */
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	@ApiModelProperty(value = "整改id")
	private Integer rectificMeasureId;
	
	/**
	 * 计划完成时间
	 */
	@Future
	// 将来的时间
	@ApiModelProperty(value = "计划完成时间")
	private Date planCompletTime;
	
	/**
	 * 整改牵头部门名称
	 */
	@NotEmpty(message = "整改牵头部门名称不能为空")
	@Valid
	@ApiModelProperty(value = "整改牵头部门名称", required = true)
	private String rectificDeptName;
	
	/**
	 * 整改牵头部门id
	 */
	@NotEmpty(message = "整改牵头部门id不能为空")
	@Valid
	@ApiModelProperty(value = "整改牵头部门id", required = true)
	private Integer rectificDeptId;
	
	/**
	 * 整改牵头人
	 */
	@NotEmpty(message = "整改牵头人不能为空")
	@Valid
	@ApiModelProperty(value = "整改牵头人", required = true)
	private String rectificLeaderName;
	
	/**
	 * 整改配合部门
	 */
	@NotEmpty(message = "整改配合部门不能为空")
	@Valid
	@ApiModelProperty(value = "整改配合部门", required = true)
	private String rectificCooperatDept;
	
	/**
	 * 整改状态 1：已整改: 2：未整改、3：无法整改: 4：整改中
	 */
	@NotEmpty(message = "整改状态不能为空")
	@Valid
	@ApiModelProperty(value = "整改状态 1：已整改: 2：未整改、3：无法整改: 4：整改中", required = true)
	private String rectificStatus;
	
	/**
	 * 整理类型：1：短期，2：长期
	 */
	@NotEmpty(message = "整理类型不能为空")
	@Valid
	@ApiModelProperty(value = "整理类型：1：短期，2：长期", required = true)
	private String rectificType;
	
	public Integer getRectificMeasureId() {
		return rectificMeasureId;
	}
	
	public void setRectificMeasureId(Integer rectificMeasureId) {
		this.rectificMeasureId = rectificMeasureId;
	}
	
	public Date getPlanCompletTime() {
		return planCompletTime;
	}
	
	public void setPlanCompletTime(Date planCompletTime) {
		this.planCompletTime = planCompletTime;
	}
	
	public String getRectificDeptName() {
		return rectificDeptName;
	}
	
	public void setRectificDeptName(String rectificDeptName) {
		this.rectificDeptName = rectificDeptName;
	}
	
	public Integer getRectificDeptId() {
		return rectificDeptId;
	}
	
	public void setRectificDeptId(Integer rectificDeptId) {
		this.rectificDeptId = rectificDeptId;
	}
	
	public String getRectificLeaderName() {
		return rectificLeaderName;
	}
	
	public void setRectificLeaderName(String rectificLeaderName) {
		this.rectificLeaderName = rectificLeaderName;
	}
	
	public String getRectificCooperatDept() {
		return rectificCooperatDept;
	}
	
	public void setRectificCooperatDept(String rectificCooperatDept) {
		this.rectificCooperatDept = rectificCooperatDept;
	}
	
	public String getRectificStatus() {
		return rectificStatus;
	}
	
	public void setRectificStatus(String rectificStatus) {
		this.rectificStatus = rectificStatus;
	}
	
	public String getRectificType() {
		return rectificType;
	}
	
	public void setRectificType(String rectificType) {
		this.rectificType = rectificType;
	}
	
}
