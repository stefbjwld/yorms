package cn.com.yusys.console.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 风险等级库
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_risk_level")
@ApiModel(value = "TRiskLevel", description = "风险等级库")
public class TRiskLevel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键", required = false)
	private int id;
	
	/**
	 * 风险等级
	 */
	@Column(name = "level_no")
	@ApiModelProperty(value = "风险等级", required = true)
	private int levelNo;
	
	/**
	 * 风险等级名称
	 */
	@Column(name = "level_name")
	@ApiModelProperty(value = "风险等级名称", required = true)
	private String levelName;
	
	/**
	 * 风险影响
	 */
	@Column(name = "risk_impact")
	@ApiModelProperty(value = "风险影响", required = true)
	private String riskImpact;
	
	/**
	 * 风险值
	 */
	@Column(name = "level_value")
	@ApiModelProperty(value = "风险值", required = true)
	private String levelValue;
	
	@Column(name = "risk_description")
	@ApiModelProperty(value = "风险描述")
	private String riskDescription;
	
	@Column(name = "risk_no")
	@ApiModelProperty(value = "风险编号")
	private String riskNo;
	
	@Column(name = "risk_status")
	@ApiModelProperty(value = "风险状态【0激活，1新录入，2审批，3废弃】")
	private int riskStatus;
	
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
	
	public String getLevelValue() {
		return levelValue;
	}
	
	public void setLevelValue(String levelValue) {
		this.levelValue = levelValue;
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
	
	public int getRiskStatus() {
		return riskStatus;
	}
	
	public void setRiskStatus(int riskStatus) {
		this.riskStatus = riskStatus;
	}
	
}
