package yorms.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import yorms.pojo.user.Authority;
import yorms.pojo.user.GroupM;
import yorms.pojo.user.User;
import yorms.repository.AuthorityRepository;
import yorms.repository.GroupMRepository;
import yorms.repository.UserRepository;
import yorms.service.UserService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements  UserDetailsService,UserService{

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private GroupMRepository groupMRepository;
    
    @Autowired
    private AuthorityRepository authorityRepository;
    
    
    @Override
    @Transactional
    public List<User> getUserList() {
        return userRepository.findAll();
    }
    
    @Override
    @Transactional
	public List<GroupM> getGroupMList() {
		// TODO Auto-generated method stub
		return groupMRepository.findAll();
	}

	@Override
	@Transactional
	public List<Authority> getAuthoriytList() {
		// TODO Auto-generated method stub
		return authorityRepository.findAll();
	}
	
	
	
	

    @Override
    @Transactional
    public User findUserById(long id) {
        return userRepository.findById(id);
    }
    
    
    @Override
    @Transactional
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
    	User user = userRepository.findByUserName(username);

		return userRepository.findByUserName(username);
	}
    

    @Override
    @Transactional
	public GroupM findGroupMById(long id) {
		// TODO Auto-generated method stub
		return groupMRepository.findById(id);
	}

	@Override
	@Transactional
	public Authority findAuthorityById(long id) {
		// TODO Auto-generated method stub
		return authorityRepository.findById(id);
	}
	
	
	
	
    
    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }
    
    @Override
    @Transactional
	public void save(GroupM groupM) {
    	groupMRepository.save(groupM);
	}

	@Override
	@Transactional
	public void save(Authority authority) {
		authorityRepository.save(authority);
		
	}

	
	
	
    @Override
    @Transactional
    public void edit(User user) {
        userRepository.save(user);
    }
    
    @Override
    @Transactional
	public void edit(GroupM groupM) {
    	groupMRepository.save(groupM);
	}

	@Override
	@Transactional
	public void edit(Authority authority) {
		authorityRepository.save(authority);
	}

	
	@Override
	@Transactional
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteGroupM(long id) {
		groupMRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void deleteAuthority(long id) {
		authorityRepository.deleteById(id);
	}
	
	
	
	
	@Override
	@Transactional
	public Page<User> findAllUserPage(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Page<GroupM> findAllGroupMPage(Pageable pageable) {
		return groupMRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Page<Authority> findAllAuthorityPage(Pageable pageable) {
		return authorityRepository.findAll(pageable);
	}
	
	
	
	
	
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = this.findByUserName(username);
		
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			
			List<GroupM> userGroupMs = user.getGroupMs();
			
			List<String> userGroupGrantedAuthoritie = new ArrayList<String>();
			
			for (GroupM groupM : userGroupMs) {
				List<Authority> groupAuthorities = groupM.getAuthorities();
				for (Authority authority : groupAuthorities) {
					userGroupGrantedAuthoritie.add(authority.getAuthorityName());
				}
			}		
			List<Authority> userAuthorities = user.getAuthorities();
			for (Authority authority : userAuthorities) {
				userGroupGrantedAuthoritie.add(authority.getAuthorityName());
			}
			
			userGroupGrantedAuthoritie.stream().distinct();	
			Collections.reverse(userGroupGrantedAuthoritie);
			
			for (String authorityName : userGroupGrantedAuthoritie) {
				authorities.add(new SimpleGrantedAuthority(authorityName));
			}
			
			
			org.springframework.security.core.userdetails.User springSecurityUser = new org.springframework.security.core.userdetails.User(
					user.getUserName(), user.getPassword(), authorities);
			return springSecurityUser;
		}else {
			throw new UsernameNotFoundException("User '"+ username +"' not found.");
		}
	}
	
	
	
	@Override
	@Transactional
	public void dealUserAddJSON(JSONObject jsonParam) {
		// TODO Auto-generated method stub
		JSONObject groupIds = jsonParam.getJSONObject("groups");
		
		JSONObject roleIds = jsonParam.getJSONObject("roles");
		
		List<GroupM> groupMs = new ArrayList<GroupM>();
		List<Authority> authorities = new ArrayList<Authority>();
		
		for (int i = 0; i < groupIds.size(); i++) {
			GroupM groupM = this.findGroupMById(groupIds.getIntValue("groupId" + i));
			groupMs.add(groupM);
		}
		
		for (int i = 0; i < roleIds.size(); i++) {
			Authority authority = this.findAuthorityById(roleIds.getIntValue("roleId" + i));
			authorities.add(authority);
		}
		
		User user = new User();
		
		user.setUserName(jsonParam.getString("userName"));
		user.setPassword(jsonParam.getString("password"));
		user.setUserDesc(jsonParam.getString("userDesc"));
		user.setCompany(jsonParam.getString("company"));
		user.setEnable(jsonParam.getString("enable"));
		user.setGroupMs(groupMs);
		user.setAuthorities(authorities);
		
		this.save(user);
		
	}

	@Override
	@Transactional
	public void dealUserEditJSON(JSONObject jsonParam) {
		// TODO Auto-generated method stub
		JSONObject groupIds = jsonParam.getJSONObject("groups");
		
		JSONObject roleIds = jsonParam.getJSONObject("roles");
		
		List<GroupM> groupMs = new ArrayList<GroupM>();
		List<Authority> authorities = new ArrayList<Authority>();
		
		for (int i = 0; i < groupIds.size(); i++) {
			GroupM groupM = this.findGroupMById(groupIds.getIntValue("groupId" + i));
			groupMs.add(groupM);
		}
		
		for (int i = 0; i < roleIds.size(); i++) {
			Authority authority = this.findAuthorityById(roleIds.getIntValue("roleId" + i));
			authorities.add(authority);
		}
		
		User user = this.findUserById(Integer.parseInt(jsonParam.getString("id")));
		
		user.setUserName(jsonParam.getString("userName"));
		user.setUserDesc(jsonParam.getString("userDesc"));
		user.setCompany(jsonParam.getString("company"));
		user.setEnable(jsonParam.getString("enable"));
		user.setGroupMs(groupMs);
		user.setAuthorities(authorities);
		
		this.save(user);
		
	}

	@Override
	@Transactional
	public void dealGroupAuthorityGrantJSON(JSONObject jsonParam) {
		// TODO Auto-generated method stub
		JSONObject roleIds = jsonParam.getJSONObject("roles");
		List<Authority> authorities = new ArrayList<Authority>();
		for (int i = 0; i < roleIds.size(); i++) {
			Authority authority = this.findAuthorityById(roleIds.getIntValue("roleId" + i));
			authorities.add(authority);
		}
		GroupM groupM = this.findGroupMById(Integer.parseInt(jsonParam.getString("id")));
		groupM.setAuthorities(authorities);
		this.save(groupM);
	}

	@Override
	@Transactional
	public Page<User> findUserListByFilterCriteria(Long groupId, Long roleId, String enable, Pageable pageable) {
		// TODO Auto-generated method stub
		
		List<User> users = this.getUserList();
		
		List<User> filteredUsers = new ArrayList<User>();
		
		
		
		for (User user : users) {
			
			boolean groupFlag = false;
			boolean roleFlag = false;
			boolean enableFlag = false;
			
			if (groupId == null) {
				groupFlag = true;
			}
			if (roleId == null) {
				roleFlag = true;
			}
			if (enable.equals("")) {
				enableFlag = true;
			}
			
			List<GroupM> groupMs = user.getGroupMs();
			for (GroupM groupM : groupMs) {
				if (groupM.getId() == groupId) {
					groupFlag = true;
				}
			}
			
			List<Authority> authorities = user.getAuthorities();
			
			for (Authority authority : authorities) {
				if (authority.getId() == roleId) {
					roleFlag = true;
				}
			}
			
		
			if (user.getEnable().equals(enable)) {
				enableFlag = true;
			}
			
			if (groupFlag&&roleFlag&&enableFlag) {
				filteredUsers.add(user);
			}

		}
		
		Collections.reverse(filteredUsers);
		
		//手动分页
		if (pageable.getOffset() > filteredUsers.size()) {
			long total = 0L;
		    PageImpl<User> usersPage = new PageImpl<>(filteredUsers, pageable, total);
		    return usersPage;
		}

		if (pageable.getOffset() <= filteredUsers.size() && pageable.getOffset() + pageable.getPageSize() > filteredUsers.size()) {
		    List<User> thisPageUser = filteredUsers.subList( (int) pageable.getOffset(), filteredUsers.size());
		    PageImpl<User> usersPage = new PageImpl<>(thisPageUser, pageable, filteredUsers.size());
		    return usersPage;
		}

		List<User> userList = filteredUsers.subList((int) pageable.getOffset(), (int)pageable.getOffset() + pageable.getPageSize());

		PageImpl<User> usersPage = new PageImpl<>(userList, pageable, filteredUsers.size());
	    
		return usersPage;
	}


	

}


