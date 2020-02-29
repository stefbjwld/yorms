package cn.com.yusys.console.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_regulation_type")
public class RegulationType implements Serializable{
	
    private static final long serialVersionUID = 1236714062716259751L;

	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * 制度二级分类名称
	 */
	@Column(name = "type_name")
	private String typeName;

	/**
	 * 制度二级分类编码
	 */
	@Column(name = "type_code")
	private String typeCode;
	
	/**
	 * 制度一级分类名称 :内规和外规
	 */
	@Column(name = "type_tree_name")
	private String typeTreeName;
	
	/**
	 * 制度一级分类编码 :00001：外规，00002：内规
	 */
	@Column(name = "type_tree_code")
	private String typeTreeCode;

	
    public int getId() {
    	return id;
    }

	
    public void setId(int id) {
    	this.id = id;
    }

	
    public String getTypeName() {
    	return typeName;
    }

	
    public void setTypeName(String typeName) {
    	this.typeName = typeName;
    }

	
    public String getTypeCode() {
    	return typeCode;
    }

	
    public void setTypeCode(String typeCode) {
    	this.typeCode = typeCode;
    }

	
    public String getTypeTreeName() {
    	return typeTreeName;
    }

	
    public void setTypeTreeName(String typeTreeName) {
    	this.typeTreeName = typeTreeName;
    }

	
    public String getTypeTreeCode() {
    	return typeTreeCode;
    }

	
    public void setTypeTreeCode(String typeTreeCode) {
    	this.typeTreeCode = typeTreeCode;
    }
	
	
}
