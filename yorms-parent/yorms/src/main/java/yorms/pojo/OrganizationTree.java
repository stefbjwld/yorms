package yorms.pojo;

import java.util.List;

public class OrganizationTree {
	 	
		private Organization organization;
		
		List<OrganizationTree> organizationTrees;

		public Organization getOrganization() {
			return organization;
		}

		public void setOrganization(Organization organization) {
			this.organization = organization;
		}

		public List<OrganizationTree> getOrganizationTrees() {
			return organizationTrees;
		}

		public void setOrganizationTrees(List<OrganizationTree> organizationTrees) {
			this.organizationTrees = organizationTrees;
		}
}
