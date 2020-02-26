package cn.com.yusys.console.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 政策法规制度请求参数实体
 * @author Administrator
 *
 */
public class RegulatPolicRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String regulationName;
	private String regulationNo;
	
	private int grpId;
	
	private int regulationType;
	
	private String status;
	
	private String deptNo;
	
	private Date date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "RegulatPolicRequest [id=" + id + ", regulationName=" + regulationName + ", regulationNo=" + regulationNo
		        + ", grpId=" + grpId + ", regulationType=" + regulationType + ", status=" + status + ", deptNo=" + deptNo
		        + ", date=" + date + "]";
	}
	
}
