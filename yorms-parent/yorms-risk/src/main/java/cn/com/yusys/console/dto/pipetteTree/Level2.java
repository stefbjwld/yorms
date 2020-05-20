package cn.com.yusys.console.dto.pipetteTree;

import java.util.List;

public class Level2 {
	
	private Integer level2Id;
	private String level2Name;
	
	private List<PipetteObj> piptteObjList;

	
    public Integer getLevel2Id() {
    	return level2Id;
    }

	
    public void setLevel2Id(Integer level2Id) {
    	this.level2Id = level2Id;
    }

	
    public String getLevel2Name() {
    	return level2Name;
    }

	
    public void setLevel2Name(String level2Name) {
    	this.level2Name = level2Name;
    }

	
    public List<PipetteObj> getPiptteObjList() {
    	return piptteObjList;
    }

	
    public void setPiptteObjList(List<PipetteObj> piptteObjList) {
    	this.piptteObjList = piptteObjList;
    }
	
	
	
}
