package cn.com.yusys.console.dto.regulatPolic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * 政策法规制度请求参数实体
 * @author Administrator
 *
 */
@ApiModel(value = "AddRegulatPolicRequest", description = "政策法规制度实体模型")
public class AddRegulatPolicRequest {
	
	@NotEmpty(message = "制度名称不能为空")
	@Valid
	@ApiModelProperty(value = "制度名称", required = true)
	private String regulationName;
	
	@NotEmpty(message = "制度名文号不能为空")
	@Valid
	@ApiModelProperty(value = "制度名文号", required = true)
	private String regulationNo;
	
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	@ApiModelProperty(value = "发布机构ID", required = true)
	private int grpId;
	
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	@ApiModelProperty(value = "制度分类ID", required = true)
	private int regulationType;
	
	@Size(max=1,min=1)
	@Valid
	@ApiModelProperty(value = "启用状态", required = true)
	private String status;
	
	@NotEmpty(message = "启用状态不能为空")
	@Valid
	@ApiModelProperty(value = "部门名称不能为空", required = true)
	private String deptNo;
	
	public String getRegulationName() {
		return regulationName;
	}
	
	public void setRegulationName(String regulationName) {
		this.regulationName = regulationName;
	}
	
	public String getRegulationNo() {
		return regulationNo;
	}
	
	public void setRegulationNo(String regulationNo) {
		this.regulationNo = regulationNo;
	}
	
	public int getGrpId() {
		return grpId;
	}
	
	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}
	
	public int getRegulationType() {
		return regulationType;
	}
	
	public void setRegulationType(int regulationType) {
		this.regulationType = regulationType;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDeptNo() {
		return deptNo;
	}
	
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	
}
