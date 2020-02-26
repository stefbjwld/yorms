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
	 * 制度分类名称
	 */
	@Column(name = "type_name")
	private int typeName;

	
    public int getId() {
    	return id;
    }

	
    public void setId(int id) {
    	this.id = id;
    }

	
    public int getTypeName() {
    	return typeName;
    }

	
    public void setTypeName(int typeName) {
    	this.typeName = typeName;
    }


	@Override
    public String toString() {
	    return "RegulationType [id=" + id + ", typeName=" + typeName + "]";
    }
	
	
}
