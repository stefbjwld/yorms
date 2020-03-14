//package cn.com.yusys.console.dto;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
///**
// * 政策法规分类请求参数实体
// * @author Administrator
// *
// */
//@ApiModel(value = "RegulationTypeRequest", description = "政策法规分类实体模型")
//public class RegulationTypeRequest {
//	
//	@ApiModelProperty(value = "主键ID", required = false)
//	private int id;
//	
//	@ApiModelProperty(value = "制度二级分类名称", required = false)
//	private String typeName;
//	
//	@ApiModelProperty(value = "制度二级分类编码", required = false)
//	private String typeCode;
//	
//	@ApiModelProperty(value = "制度一级分类名称 内规和外规", required = false)
//	private String typeTreeName;
//	
//	@ApiModelProperty(value = "制度一级分类编码 00001：外规，00002：内规", required = false)
//	private String typeTreeCode;
//	
//	@ApiModelProperty(value = "附件上传HDFS路径地址", required = false)
//	private String imgPath;
//	
//	public int getId() {
//		return id;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getTypeName() {
//		return typeName;
//	}
//	
//	public void setTypeName(String typeName) {
//		this.typeName = typeName;
//	}
//	
//	public String getTypeCode() {
//		return typeCode;
//	}
//	
//	public void setTypeCode(String typeCode) {
//		this.typeCode = typeCode;
//	}
//	
//	public String getTypeTreeName() {
//		return typeTreeName;
//	}
//	
//	public void setTypeTreeName(String typeTreeName) {
//		this.typeTreeName = typeTreeName;
//	}
//	
//	public String getTypeTreeCode() {
//		return typeTreeCode;
//	}
//	
//	public void setTypeTreeCode(String typeTreeCode) {
//		this.typeTreeCode = typeTreeCode;
//	}
//	
//	public String getImgPath() {
//		return imgPath;
//	}
//	
//	public void setImgPath(String imgPath) {
//		this.imgPath = imgPath;
//	}
//	
//}
