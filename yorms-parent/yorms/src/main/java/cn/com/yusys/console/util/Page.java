package cn.com.yusys.console.util;

import java.util.List;


public class Page<T> {
	
	private List<T> pageData;//查询结果
	private Integer total;//总的记录数
	
    public List<T> getPageData() {
    	return pageData;
    }
	
    public void setPageData(List<T> pageData) {
    	this.pageData = pageData;
    }
	
    public Integer getTotal() {
    	return total;
    }
	
    public void setTotal(Integer total) {
    	this.total = total;
    }
	
	
}
