package yorms.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.alibaba.fastjson.JSONObject;

import yorms.pojo.user.Authority;
import yorms.pojo.user.GroupM;
import yorms.pojo.user.User;

public interface UserService extends UserDetailsService{

    public List<User> getUserList();
    
    public List<GroupM> getGroupMList();
    
    public List<Authority> getAuthoriytList();

    
    public User findUserById(long id);
    
    public User findByUserName(String username);
    
    public GroupM findGroupMById(long id);
    
    public Authority findAuthorityById(long id);

    
    
    public void save(User user);
    
    public void save(GroupM groupM);
    
    public void save(Authority authority);

    
    
    public void edit(User user);
    
    public void edit(GroupM groupM);
    
    public void edit(Authority authority);

    
    
    public void deleteUser(long id);
    
    public void deleteGroupM(long id);
    
    public void deleteAuthority(long id);
    
    
    
    public Page<User> findAllUserPage(Pageable pageable);
    
    public Page<GroupM> findAllGroupMPage(Pageable pageable);
    
    public Page<Authority> findAllAuthorityPage(Pageable pageable);
    
    
    public void dealUserAddJSON(JSONObject jsonParam);
    public void dealUserEditJSON(JSONObject jsonParam);
    public void dealGroupAuthorityGrantJSON(JSONObject jsonParam);
    
    
    public Page<User> findUserListByFilterCriteria(Long groupId,Long roleId,String enable,Pageable pageable);

}
