package cn.com.yusys.console.dto.questionBank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "TQuestionBankRequest", description = "新增问题")
public class AddQuestionBankRequest {
	
	@ApiModelProperty(value = "整改序号", required = true)
	@NotEmpty(message = "整改序号不能为空")
	@Valid
	private String rectificId;
	
	@ApiModelProperty(value = "问题分类", required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	private Integer questionType;
	
	@ApiModelProperty(value = "问题描述不能为空", required = true)
	@NotEmpty(message = "问题描述不能为空")
	@Valid
	private String description;
	
	@ApiModelProperty(value = "整改措施id不能为空", required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	private Integer rectificMeasureId;
	
	@ApiModelProperty(value = "发现方式不能为空", required = true)
	@NotEmpty(message = "发现方式不能为空")
	@Valid
	private String discoveryMode;
	
	@ApiModelProperty(value = "原因分析不能为空", required = true)
	@NotEmpty(message = "原因分析不能为空")
	@Valid
	private String causeAnalysis;
	
	@ApiModelProperty(value = "问题名称不能为空", required = true)
	@NotEmpty(message = "问题名称不能为空")
	@Valid
	private String questionName;
	
	@ApiModelProperty(value = "问题编号不能为空", required = true)
	@NotEmpty(message = "问题编号不能为空")
	@Valid
	private String questionNo;
	
	public String getRectificId() {
		return rectificId;
	}
	
	public void setRectificId(String rectificId) {
		this.rectificId = rectificId;
	}
	
	public Integer getQuestionType() {
		return questionType;
	}
	
	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getRectificMeasureId() {
		return rectificMeasureId;
	}
	
	public void setRectificMeasureId(Integer rectificMeasureId) {
		this.rectificMeasureId = rectificMeasureId;
	}
	
	public String getDiscoveryMode() {
		return discoveryMode;
	}
	
	public void setDiscoveryMode(String discoveryMode) {
		this.discoveryMode = discoveryMode;
	}
	
	public String getCauseAnalysis() {
		return causeAnalysis;
	}
	
	public void setCauseAnalysis(String causeAnalysis) {
		this.causeAnalysis = causeAnalysis;
	}
	
	public String getQuestionName() {
		return questionName;
	}
	
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	
	public String getQuestionNo() {
		return questionNo;
	}
	
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	
}
