package yorms.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

import yorms.pojo.Organization;

public interface OrganizationService {
	
	public void save(Organization organization);
	
	public void deleteOrg(Long id);
	
	public Organization findById(long id);
	
	/**
	 *为parent添加子节点child
	 * */
	public void addChildOrg(Organization parent,Organization child);
	
	public List<Organization> getChildOrgs(Organization organization);
	
	public long getchildrenCount(Organization organization);
	
	public long getOrganizationTreeDepth(Organization organization);
	
	/**
	 * 判断org1是否是org2的子节点*/
	public boolean isChildNode(Organization org1,Organization org2);
	
	/**
	 * 判断org1是否是org2的父节点*/
	public boolean isParentNode(Organization org1,Organization org2);
	
	public JSONArray getOrgsTreeviewJSON();
	
	/**
	 * 获取指定节点的族谱路径，以正序保存在列表中*/
	public List<Organization> getOrgPath(Organization organization);
}
