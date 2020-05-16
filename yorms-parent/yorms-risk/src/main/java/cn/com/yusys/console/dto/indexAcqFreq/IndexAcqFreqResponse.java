package cn.com.yusys.console.dto.indexAcqFreq;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 指标项管理数据展示
 * @author Administrator
 *
 */
@Entity
public class IndexAcqFreqResponse {
	
	@Id
	private Integer id;
	private String level1;
	private String level2;
	private String level3;
	private Integer riskClassifiId;
	private String indexEn;
	private String indexZh;
	private String indexDesc;
	private String indexAcqFreq;
	private String indexUnit;
	private String indexJson;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLevel1() {
		return level1;
	}
	
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	
	public String getLevel2() {
		return level2;
	}
	
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	
	public String getLevel3() {
		return level3;
	}
	
	public void setLevel3(String level3) {
		this.level3 = level3;
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
