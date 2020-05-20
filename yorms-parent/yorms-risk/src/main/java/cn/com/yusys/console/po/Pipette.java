package cn.com.yusys.console.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

/**
 * 被管对象
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_pipette")
@ApiModel(value = "Pipette", description = "被管对象")
public class Pipette implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键,新增操作时为NULL", required = false)
	private Integer id;
	
	@Column(name = "obj_name")
	@ApiModelProperty(value = "对象名称", required = true)
	@NotEmpty(message = "对象名称不能为空")
	@Valid
	private String objName;
	
	@Column(name = "obj_class")
	@ApiModelProperty(value = "对象分类", required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	private Integer objClass;
	
	@ApiModelProperty(value = "对象分类名称，用作展示，前端无需传此值")
	@Transient
	private String objClassName;
	
	@Column(name = "obj_level")
	@ApiModelProperty(value = "对象等级", required = true)
	@NotEmpty(message = "对象等级不能为空")
	@Valid
	private String objLevel;
	
	@Column(name = "obj_desc")
	@ApiModelProperty(value = "对象描述", required = false)
	private String objDesc;
	
	@Column(name = "person_liable")
	@ApiModelProperty(value = "责任人")
	private String personLiable;
	
	@Column(name = "compentent_dept")
	@ApiModelProperty(value = "主管部门")
	private String competentDept;
	
	@Column(name = "resp_unit")
	@ApiModelProperty(value = "责任单位")
	private String respUnit;
	
	@Column(name = "index_indicat")
	@ApiModelProperty(value = "风控指标")
	private String indexIndicat;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getObjName() {
		return objName;
	}
	
	public void setObjName(String objName) {
		this.objName = objName;
	}
	
	public Integer getObjClass() {
		return objClass;
	}
	
	public void setObjClass(Integer objClass) {
		this.objClass = objClass;
	}
	
	public String getObjClassName() {
		return objClassName;
	}
	
	public void setObjClassName(String objClassName) {
		this.objClassName = objClassName;
	}
	
	public String getObjLevel() {
		return objLevel;
	}
	
	public void setObjLevel(String objLevel) {
		this.objLevel = objLevel;
	}
	
	public String getObjDesc() {
		return objDesc;
	}
	
	public void setObjDesc(String objDesc) {
		this.objDesc = objDesc;
	}
	
	public String getPersonLiable() {
		return personLiable;
	}
	
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	
	public String getCompetentDept() {
		return competentDept;
	}
	
	public void setCompetentDept(String competentDept) {
		this.competentDept = competentDept;
	}
	
	public String getRespUnit() {
		return respUnit;
	}
	
	public void setRespUnit(String respUnit) {
		this.respUnit = respUnit;
	}
	
	public String getIndexIndicat() {
		return indexIndicat;
	}
	
	public void setIndexIndicat(String indexIndicat) {
		this.indexIndicat = indexIndicat;
	}
	
}
