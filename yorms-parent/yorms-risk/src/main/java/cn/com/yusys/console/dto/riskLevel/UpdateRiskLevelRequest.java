package cn.com.yusys.console.dto.riskLevel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UpdateRiskLevelRequest", description = "风险等级信息更新操作实体模型")
public class UpdateRiskLevelRequest {
	
	@ApiModelProperty(value = "主键", required = true)
	private int id;
	
	@ApiModelProperty(value = "风险等级", required = false)
	private int levelNo;
	
	@ApiModelProperty(value = "风险等级名称", required = false)
	private String levelName;
	
	@ApiModelProperty(value = "风险影响", required = false)
	private String riskImpact;
	
	@ApiModelProperty(value = "风险描述", required = false)
	private String riskDescription;
	
	@ApiModelProperty(value = "风险编号", required = false)
	private String riskNo;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
		return "UpdateRiskLevelRequest [id=" + id + ", levelNo=" + levelNo + ", levelName=" + levelName + ", riskImpact="
		        + riskImpact + ", riskDescription=" + riskDescription + ", riskNo=" + riskNo + "]";
	}
	
}
