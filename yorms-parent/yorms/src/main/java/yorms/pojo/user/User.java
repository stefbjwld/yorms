package yorms.pojo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column(nullable = false, unique = true)
    private String userName;
	
	@Column(nullable = false)
    private String password;
    
	private String company;
	
	private String userDesc;
	
	private String enable;
	
    private Date expiredDate;
    
    private Date credentialExpiredDate;
    
    private boolean locked;
    
    private boolean credentialExpired;
    
    
	
	
        
	@ManyToMany(targetEntity = GroupM.class)
    private List<GroupM> groups;
    
	@ManyToMany(targetEntity = Authority.class)
    private List<Authority> authorities;
	

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<GroupM> getGroupMs() {
		return groups;
	}

	public void setGroupMs(List<GroupM> groups) {
		this.groups = groups;
	}

	public List<Authority> getAuthority() {
		return authorities;
	}

	public void setAuthority(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getUserDesc() {
		return userDesc;
	}

	public void setUserDesc(String userDesc) {
		this.userDesc = userDesc;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<GroupM> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupM> groups) {
		this.groups = groups;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
	
	
	
	
}
