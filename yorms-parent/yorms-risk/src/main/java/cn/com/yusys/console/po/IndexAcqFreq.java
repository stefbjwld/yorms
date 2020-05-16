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
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

/**
 * 风险指标管理
 * @author Administrator
 *
 */

@Entity
@Table(name = "t_index_acq_freq")
@ApiModel(value = "IndexAcqFreq",description = "风险指标管理")
public class IndexAcqFreq implements Serializable {
	
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键,新增操作时为NULL",required = false)
	private Integer id;
	/**
	 * 风险分类ID
	 */
	@Column(name = "risk_classifi_id")
	@ApiModelProperty(value = "风险分类ID,就是三级分类的ID",required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	@Valid
	private Integer riskClassifiId;
	/**
	 * 指标英文名
	 */
	@Column(name = "index_en")
	@ApiModelProperty(value = "指标英文名",required = true)
	@NotEmpty(message = "指标英文名不能为空")
	@Valid
	private String indexEn;
	/**
	 * 指标中文名
	 */
	@Column(name = "index_zh")
	@ApiModelProperty(value = "指标中文名",required = true)
	@NotEmpty(message = "指标中文名不能为空")
	@Valid
	private String indexZh;
	/**
	 * 指标编号
	 */
	@Column(name = "index_no")
	@ApiModelProperty(value = "指标编号",required = true)
	@NotEmpty(message = "指标编号不能为空")
	@Valid
	private String indexNo;
	/**
	 * 指标描述
	 */
	@Column(name = "index_desc")
	@ApiModelProperty(value = "指标描述",required = false)
	private String indexDesc;
	/**
	 * 采集评率
	 */
	@Column(name = "index_acq_freq")
	@ApiModelProperty(value = "采集评率",required = false)
	private String indexAcqFreq;
	/**
	 * 单位
	 */
	@Column(name = "index_unit")
	private String indexUnit;
	/**
	 * 扩展字段
	 */
	@Column(name = "index_json")
	private String indexJson;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getRiskClassifiId() {
		return riskClassifiId;
	}
	
	public void setRiskClassifiId(Integer riskClassifiId) {
		this.riskClassifiId = riskClassifiId;
	}
	
	public String getIndexEn() {
		return indexEn;
	}
	
	public void setIndexEn(String indexEn) {
		this.indexEn = indexEn;
	}
	
	public String getIndexZh() {
		return indexZh;
	}
	
	public void setIndexZh(String indexZh) {
		this.indexZh = indexZh;
	}
	
	public String getIndexNo() {
		return indexNo;
	}
	
	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}
	
	public String getIndexDesc() {
		return indexDesc;
	}
	
	public void setIndexDesc(String indexDesc) {
		this.indexDesc = indexDesc;
	}
	
	public String getIndexAcqFreq() {
		return indexAcqFreq;
	}
	
	public void setIndexAcqFreq(String indexAcqFreq) {
		this.indexAcqFreq = indexAcqFreq;
	}
	
	public String getIndexUnit() {
		return indexUnit;
	}
	
	public void setIndexUnit(String indexUnit) {
		this.indexUnit = indexUnit;
	}
	
	public String getIndexJson() {
		return indexJson;
	}
	
	public void setIndexJson(String indexJson) {
		this.indexJson = indexJson;
	}
	
}
