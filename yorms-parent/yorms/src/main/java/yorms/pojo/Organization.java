package yorms.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String organization_code;
	
	private String name;
	
	private String orgDesc;
		
	private long leftId;

	private long rightId;
	
	private long layer;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrganization_code() {
		return organization_code;
	}

	public void setOrganization_code(String organization_code) {
		this.organization_code = organization_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getOrgDesc() {
		return orgDesc;
	}

	public void setOrgDesc(String orgDesc) {
		this.orgDesc = orgDesc;
	}

	public long getLeftId() {
		return leftId;
	}

	public void setLeftId(long leftId) {
		this.leftId = leftId;
	}

	public long getRightId() {
		return rightId;
	}

	public void setRightId(long rightId) {
		this.rightId = rightId;
	}

	public long getLayer() {
		return layer;
	}

	public void setLayer(long layer) {
		this.layer = layer;
	}
	
	
}


