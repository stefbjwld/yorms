package cn.com.yusys.console.dto.questionBank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryQuestionBankRequest", description = "问题列表查询实体")
public class QueryQuestionBankRequest {
	
	@ApiModelProperty(value = "主键ID", required = false)
	private Integer id;
	
	@ApiModelProperty(value = "整改序号", required = false)
	private String rectificId;
	
	@ApiModelProperty(value = "问题分类", required = false)
	private Integer questionType;
	
	@ApiModelProperty(value = "问题描述不能为空", required = false)
	private String description;
	
	@ApiModelProperty(value = "整改措施id不能为空", required = false)
	private Integer rectificMeasureId;
	
	@ApiModelProperty(value = "发现方式不能为空", required = false)
	private String discoveryMode;
	
	@ApiModelProperty(value = "原因分析不能为空", required = false)
	private String causeAnalysis;
	
	@ApiModelProperty(value = "问题名称不能为空", required = false)
	private String questionName;
	
	@ApiModelProperty(value = "问题编号不能为空", required = false)
	private String questionNo;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
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
