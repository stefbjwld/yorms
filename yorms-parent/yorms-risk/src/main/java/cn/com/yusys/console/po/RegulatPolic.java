package cn.com.yusys.console.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 政策法规制度
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_regulation_polic")
public class RegulatPolic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * 制度名称
	 */
	@Column(name = "regulation_name")
	private String regulationName;
	
	/**
	 * 制度文号
	 */
	@Column(name = "regulation_no")
	private String regulationNo;
	
	/**
	 * 发布机构
	 */
	@Column(name = "grp_id")
	private int grpId;
	
	/**
	 * 制度分类
	 */
	@Column(name = "regulation_type")
	private int regulationType;
	
	/**
	 * 启用状态
	 */
	@Column(name = "status")
	private String status;
	
	/**
	 * 部门名称
	 */
	@Column(name = "dept_no")
	private String deptNo;
	
	/**
	 * 上传日期
	 */
	@Column(name = "date")
	private Date date;
	
	/**
	 * 上传附件到HDFS的相对路径
	 */
	@Column(name = "img_path")
	private String imgPath;
	
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
	
	public String getImgPath() {
		return imgPath;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	@Override
	public String toString() {
		return "RegulatPolic [id=" + id + ", regulationName=" + regulationName + ", regulationNo=" + regulationNo + ", grpId="
		        + grpId + ", regulationType=" + regulationType + ", status=" + status + ", deptNo=" + deptNo + ", date=" + date
		        + ", imgPath=" + imgPath + "]";
	}
	
}
