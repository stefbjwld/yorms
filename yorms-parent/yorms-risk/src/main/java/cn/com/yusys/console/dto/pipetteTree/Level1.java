package cn.com.yusys.console.dto.pipetteTree;

import java.util.List;


public class Level1 {
	
	private Integer level1Id;
	private String levelName;
	
	private List<Level2> level2List;

	
    public Integer getLevel1Id() {
    	return level1Id;
    }

	
    public void setLevel1Id(Integer level1Id) {
    	this.level1Id = level1Id;
    }

	
    public String getLevelName() {
    	return levelName;
    }

	
    public void setLevelName(String levelName) {
    	this.levelName = levelName;
    }

	
    public List<Level2> getLevel2List() {
    	return level2List;
    }

	
    public void setLevel2List(List<Level2> level2List) {
    	this.level2List = level2List;
    }
	
	
}
