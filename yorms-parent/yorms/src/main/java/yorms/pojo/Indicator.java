package yorms.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import yorms.pojo.user.User;

@Entity
public class Indicator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String indicator_code;
	
	private String name;
	
	private String indicatorDesc;
		
	private long leftId;

	private long rightId;
	
	private boolean isKPI;
	
	/**
	 * 合成指标参数*/
	@OneToMany(targetEntity = Indicator.class)
	private List<Indicator> parameters;
	
	/**
	 * 提交人*/
	@OneToOne(targetEntity = User.class)
	private User user;
	
	/**
	 * 来源部门*/
	@OneToOne(targetEntity = Organization.class)
	private Organization organization;
	
	/**
	 * 提交时间*/
	private Date date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIndicator_code() {
		return indicator_code;
	}

	public void setIndicator_code(String indicator_code) {
		this.indicator_code = indicator_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndicatorDesc() {
		return indicatorDesc;
	}

	public void setIndicatorDesc(String indicatorDesc) {
		this.indicatorDesc = indicatorDesc;
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

	public boolean isKPI() {
		return isKPI;
	}

	public void setKPI(boolean isKPI) {
		this.isKPI = isKPI;
	}

	public List<Indicator> getParameters() {
		return parameters;
	}

	public void setParameters(List<Indicator> parameters) {
		this.parameters = parameters;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
