package cn.com.yusys.console.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

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

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 被管对象管理指标项扩展指标项的名称和值，比如增加一个为2的阈值，risk_kpi_name就是阈值，risk_kpi_vlaue就是2
 * @author Administrator
 *
 */
@Entity
@Table(name = "t_kpi_current_value")
@ApiModel(value = "KpiCurrentValues", description = "被管对应于指标项的关联关系表")
public class KpiCurrentValues implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键,新增操作时为NULL", required = false)
	private Integer id;
	
	@Column(name = "object_id")
	@ApiModelProperty(value = "被管对象ID", required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	private Integer objectId;// t_pipette表中的主键
	
	@Column(name = "risk_kpi_id")
	@ApiModelProperty(value = "指标项ID", required = true)
	@DecimalMin("1")
	@DecimalMax("999999999")
	private Integer indexAcqFreqId;// t_index_acq_freq表中的主键
	
	@Column(name = "risk_kpi_name")
	@ApiModelProperty(value = "关联关系中的指标名称", required = true)
	@NotEmpty(message = "关联关系中的指标名称不能为空")
	@Valid
	private String kpiName;
	
	@Column(name = "risk_kpi_value")
	@ApiModelProperty(value = "关联关系中的指标值", required = true)
	@NotEmpty(message = "关联关系中的指标值不能为空")
	@Valid
	private String kpiValue;
	
	@Column(name = "timestamp")
	@ApiModelProperty(value = "创建时间,默认值为当前时间", required = true,example = "2020-05-16 13:07:10")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp = new Date();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getObjectId() {
		return objectId;
	}
	
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	
	public Integer getIndexAcqFreqId() {
		return indexAcqFreqId;
	}
	
	public void setIndexAcqFreqId(Integer indexAcqFreqId) {
		this.indexAcqFreqId = indexAcqFreqId;
	}
	
	public String getKpiName() {
		return kpiName;
	}
	
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	
	public String getKpiValue() {
		return kpiValue;
	}
	
	public void setKpiValue(String kpiValue) {
		this.kpiValue = kpiValue;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
