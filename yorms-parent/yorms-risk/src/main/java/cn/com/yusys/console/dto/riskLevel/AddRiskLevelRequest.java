package cn.com.yusys.console.dto.riskLevel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/*
 * 风险等级添加实体
 */
@ApiModel(value = "AddRiskLevelRequest", description = "风险等级添加")
public class AddRiskLevelRequest {
	
	@NotEmpty(message = "风险等级不能为空")
	@Valid
	@ApiModelProperty(value = "风险等级", required = true)
	private int levelNo;
	
	@NotEmpty(message = "风险等级名称不能为空")
	@Valid
	@ApiModelProperty(value = "风险等级名称", required = true)
	private String levelName;
	
	@NotEmpty(message = "风险影响不能为空")
	@Valid
	@ApiModelProperty(value = "风险影响", required = true)
	private String riskImpact;
	
	@NotEmpty(message = "风险描述不能为空")
	@Valid
	@ApiModelProperty(value = "风险描述")
	private String riskDescription;
	
	@NotEmpty(message = "风险编号不能为空")
	@Valid
	@ApiModelProperty(value = "风险编号")
	private String riskNo;
	
	public int getLevelNo() {
		return levelNo;
	}
	
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	
	public String getLevelName() {
		return levelName;
	}
	
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	
	public String getRiskImpact() {
		return riskImpact;
	}
	
	public void setRiskImpact(String riskImpact) {
		this.riskImpact = riskImpact;
	}
	
	public String getRiskDescription() {
		return riskDescription;
	}
	
	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}
	
	public String getRiskNo() {
		return riskNo;
	}
	
	public void setRiskNo(String riskNo) {
		this.riskNo = riskNo;
	}
	
	@Override
	public String toString() {
		return "AddRiskLevelRequest [levelNo=" + levelNo + ", levelName=" + levelName + ", riskImpact=" + riskImpact
		        + ", riskDescription=" + riskDescription + ", riskNo=" + riskNo + "]";
	}
	
}
