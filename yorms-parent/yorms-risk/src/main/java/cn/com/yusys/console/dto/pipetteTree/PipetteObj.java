package cn.com.yusys.console.dto.pipetteTree;

import java.util.List;

public class PipetteObj {
	
	private Integer objId;
	private String objName;
	
	private List<IndexAcqFreq2> indexAcqFreqList;
	
	public Integer getObjId() {
		return objId;
	}
	
	public void setObjId(Integer objId) {
		this.objId = objId;
	}
	
	public String getObjName() {
		return objName;
	}
	
	public void setObjName(String objName) {
		this.objName = objName;
	}
	
	public List<IndexAcqFreq2> getIndexAcqFreqList() {
		return indexAcqFreqList;
	}
	
	public void setIndexAcqFreqList(List<IndexAcqFreq2> indexAcqFreqList) {
		this.indexAcqFreqList = indexAcqFreqList;
	}
	
}
