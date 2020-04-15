package cn.com.yusys.console.dto.rectificMeasure;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "QueryTRectificMeasureRequest", description = "查询整改措施")
public class QueryTRectificMeasureRequest {
	
	@ApiModelProperty(value = "主鍵id", required = false)
	private Integer id;
	
	@ApiModelProperty(value = "整改id", required = false)
	private Integer rectificMeasureId;
	
	@ApiModelProperty(value = "计划完成时间", required = false)
	private Date planCompletTime;
	
	@ApiModelProperty(value = "整改牵头部门名称", required = false)
	private String rectificDeptName;
	
	@ApiModelProperty(value = "整改牵头部门id", required = false)
	private Integer rectificDeptId;
	
	@ApiModelProperty(value = "整改牵头人", required = false)
	private String rectificLeaderName;
	
	@ApiModelProperty(value = "整改配合部门", required = false)
	private String rectificCooperatDept;
	
	/**
	 * 整改状态 1：已整改: 2：未整改、3：无法整改: 4：整改中
	 */
	@ApiModelProperty(value = "整改状态 1：已整改: 2：未整改、3：无法整改: 4：整改中", required = false)
	private String rectificStatus;
	
	/**
	 * 整理类型：1：短期，2：长期
	 */
	@ApiModelProperty(value = "整理类型：1：短期，2：长期", required = false)
	private String rectificType;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
