//package cn.com.yusys.console.dto;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//import java.util.Date;
//
///**
// * 政策法规制度请求参数实体
// * @author Administrator
// *
// */
//@ApiModel(value = "RegulatPolicRequest",description = "政策法规制度实体模型")
//public class RegulatPolicRequest{
//	
//	@ApiModelProperty(value = "主键ID",required = false)
//	private int id;
//	
//	@ApiModelProperty(value = "制度名称",required = false)
//	private String regulationName;
//	
//	@ApiModelProperty(value = "制度名文号",required = false)
//	private String regulationNo;
//	
//	@ApiModelProperty(value = "发布机构ID",required = false)
//	private int grpId;
//	
//	@ApiModelProperty(value = "制度分类ID",required = false)
//	private int regulationType;
//	
//	@ApiModelProperty(value = "启用状态",required = false)
//	private String status;
//	
//	@ApiModelProperty(value = "部门名称",required = false)
//	private String deptNo;
//	
//	@ApiModelProperty(value = "上传日期",required = false)
//	private Date date;
//	
//	public int getId() {
//		return id;
//	}
//	
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getRegulationName() {
//		return regulationName;
//	}
//	
//	public void setRegulationName(String regulationName) {
//		this.regulationName = regulationName;
//	}
//	
//	public String getRegulationNo() {
//		return regulationNo;
//	}
//	
//	public void setRegulationNo(String regulationNo) {
//		this.regulationNo = regulationNo;
//	}
//	
//	public int getGrpId() {
//		return grpId;
//	}
//	
//	public void setGrpId(int grpId) {
//		this.grpId = grpId;
//	}
//	
//	public int getRegulationType() {
//		return regulationType;
//	}
//	
//	public void setRegulationType(int regulationType) {
//		this.regulationType = regulationType;
//	}
//	
//	public String getStatus() {
//		return status;
//	}
//	
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	
//	public String getDeptNo() {
//		return deptNo;
//	}
//	
//	public void setDeptNo(String deptNo) {
//		this.deptNo = deptNo;
//	}
//	
//	public Date getDate() {
//		return date;
//	}
//	
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	
//	@Override
//	public String toString() {
//		return "RegulatPolicRequest [id=" + id + ", regulationName=" + regulationName + ", regulationNo=" + regulationNo
//		        + ", grpId=" + grpId + ", regulationType=" + regulationType + ", status=" + status + ", deptNo=" + deptNo
//		        + ", date=" + date + "]";
//	}
//	
//}
