package cn.com.yusys.console.dto.regulationType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;



/**
 * 政策法规分类请求参数实体
 * @author Administrator
 *
 */
@ApiModel(value = "AddRegulationTypeRequest", description = "政策法规分类实体模型")
public class AddRegulationTypeRequest{
	
	@ApiModelProperty(value = "制度二级分类名称", required = true)
	@NotEmpty(message = "制度二级分类名称不能为空")
	@Valid
	private String typeName;
	
	@ApiModelProperty(value = "制度一级分类编码 00001：外规，00002：内规", required = true)
	@NotEmpty(message = "制度一级分类编码不能为空")
	@Valid
	private String typeTreeCode;

	
    public String getTypeName() {
    	return typeName;
    }

	
    public void setTypeName(String typeName) {
    	this.typeName = typeName;
    }

	
    public String getTypeTreeCode() {
    	return typeTreeCode;
    }

	
    public void setTypeTreeCode(String typeTreeCode) {
    	this.typeTreeCode = typeTreeCode;
    }
	
	
}
