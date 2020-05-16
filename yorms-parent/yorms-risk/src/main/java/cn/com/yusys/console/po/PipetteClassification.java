package cn.com.yusys.console.po;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * 被管对象分类
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_pipette_classification")
@ApiModel(value = "PipetteClassification", description = "被管对象分类")
public class PipetteClassification implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键,新增操作时为NULL", required = false)
	private Integer id;
	@Column(name = "parent_id")
	@ApiModelProperty(value = "分类父节点ID,一级分类时，parentId为0", required = true)
	@Valid
	private Integer parentId;
	@Column(name = "name")
	@ApiModelProperty(value = "被管对象分类名称", required = true)
	@NotEmpty(message = "被管对象分类名称不能为空")
	@Valid
	private String name;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getParentId() {
		return parentId;
	}
	
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
