package yorms.repository;

import java.util.List;

import yorms.pojo.Organization;

public interface OrganizationRepositorySweeper {
	public List<Organization> getChildOrganizationsByPreorderTraversal(Organization organization);
	
	public void addChildOrg(Organization parent,Organization child);
	
	public void deleteOrg(Long id);
}
