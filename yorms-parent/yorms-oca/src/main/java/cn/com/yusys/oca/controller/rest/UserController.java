package cn.com.yusys.oca.controller.rest;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.file.util.OutputData;
import cn.com.yusys.oca.dto.GroupRequest;
import cn.com.yusys.oca.dto.UserAuthoityRelRequest;
import cn.com.yusys.oca.dto.UserGroupRelRequest;
import cn.com.yusys.oca.dto.UserRequest;
import cn.com.yusys.oca.po.Authority;
import cn.com.yusys.oca.po.Group;
import cn.com.yusys.oca.po.User;
import cn.com.yusys.oca.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @项目名称 yorms-oca 
 * @类名称 UserController 
 * @类描述 
 * @功能描述:
 * @创建人：zhangal@yusys.com.cn
 * @创建时间：2020/3/10
 * @修改备注：
 * @修改日期 修改人员 修改原因 
 * @version 1.0.0
 * @Copyright (c) 
 */

@RestController
@RequestMapping("/User")
@Api(value = "/User")
public class UserController {
	
	@Resource
	UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	
	
	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "/userAdd",notes = "Add user")
	public OutputData userAdd(@RequestBody UserRequest request) {
		
		OutputData out = new OutputData().returnSuccess();
		
		User user = new User();
		
		try {
			try {
				BeanUtils.copyProperties(user, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("Request convert Exception {}",e);
	        	return out.returnFail(e.getMessage());
			}
			userService.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Add user Exception{}",e);
			out.returnFail(e.getMessage());
		}
		return out;
		
	}
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryAll",method = RequestMethod.GET)
	@ApiOperation(value = "/queryAll",notes = "Query all users")
	public OutputData queryAll(){
		OutputData out = new OutputData().returnSuccess();
		
		List<User> userList = new ArrayList<User>();
		try{
			userList = userService.getUserList();
			
			out.setData(userList);
			
		}catch(Exception e){
			log.info("Query all user Exception {}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryUserGroups",method = RequestMethod.GET)
	@ApiOperation(value = "/queryUserGroups",notes = "Query user groups")
	public OutputData queryUserGroups(Long userId){
		OutputData out = new OutputData().returnSuccess();
		
		List<Group> groupList = new ArrayList<Group>();
		try{
			groupList = userService.findUserGroups(userId);
			
			out.setData(groupList);
			
		}catch(Exception e){
			log.info("Query user groups Exception {}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryUserAuthoritys",method = RequestMethod.GET)
	@ApiOperation(value = "/queryUserAuthoritys",notes = "Query user authoritys")
	public OutputData queryUserAuthoritys(Long userId){
		OutputData out = new OutputData().returnSuccess();
		
		List<Authority> authorities = new ArrayList<Authority>();
		try{
			authorities = userService.findUserAuthoritys(userId);
			out.setData(authorities);
			
		}catch(Exception e){
			log.info("Query user authoritys Exception {}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryUsersByGroupId",method = RequestMethod.GET)
	@ApiOperation(value = "/queryUsersByGroupId",notes = "Query users by groupId")
	public OutputData queryUsersByGroupId(Long groupId){
		OutputData out = new OutputData().returnSuccess();
		
		List<User> userList = new ArrayList<User>();
		try{
			userList = userService.findUsersByGroup(groupId);
			
			out.setData(userList);
		}catch(Exception e){
			log.info("Query users by groupId Exception {}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/queryUsersByAuthorityId",method = RequestMethod.GET)
	@ApiOperation(value = "/queryUsersByAuthorityId",notes = "Query users by authorityId")
	public OutputData queryUsersByAuthorityId(Long authorityId){
		OutputData out = new OutputData().returnSuccess();
		
		List<User> userList = new ArrayList<User>();
		try{
			userList = userService.findUsersByAuthority(authorityId);
			
			out.setData(userList);
		}catch(Exception e){
			log.info("Query users by authorityId Exception {}",e);
			out.returnFail(e.getMessage());
		}
		return out;
	}
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/userManage", method = RequestMethod.GET)
	@ApiOperation(value = "/userManage",notes = "Query users by page option")
	public OutputData userManage(Integer pageSize,Integer page) {
		
		OutputData out = new OutputData().returnSuccess();
		
		if(pageSize == null || pageSize<1){
			pageSize = 10;
		}
		if(page == null || page<1){
			page = 0;
		}
		
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page,pageSize);
		
		Page<User> pageUsers = userService.findAllUserPage(pageable);
		
		out.setData(pageUsers);
		
		return out;
	}
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
	@ApiOperation(value = "/userUpdate",notes = "Update user")
	public OutputData userUpdate(@RequestBody UserRequest request,Integer pageSize,Integer page) {
		
		OutputData out = new OutputData().returnSuccess();
		
		User user = new User();
		
		try {
			try {
				BeanUtils.copyProperties(user, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("Request convert Exception {}",e);
	        	return out.returnFail(e.getMessage());
			}
			userService.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Update user Exception{}",e);
			out.returnFail(e.getMessage());
		}
		
		if(pageSize == null || pageSize<1){
			pageSize = 10;
		}
		if(page == null || page<1){
			page = 0;
		}
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page,pageSize);
		
		Page<User> pageUser = userService.findAllUserPage(pageable);
		
		out.setData(pageUser);
		
		return out;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping(value = "/userDelete", method = RequestMethod.POST)
	@ApiOperation(value = "/userDelete",notes = "Delete user")
	public OutputData userDelete(@RequestBody UserRequest request,Integer pageSize,Integer page) {
		
		OutputData out = new OutputData().returnSuccess();
		
		User user = new User();
		
		try {
			try {
				BeanUtils.copyProperties(user, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error("Request convert Exception {}",e);
	        	return out.returnFail(e.getMessage());
			}
			userService.deleteUser(user.getId());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Delete user Exception{}",e);
			out.returnFail(e.getMessage());
		}
		
		if(pageSize == null || pageSize<1){
			pageSize = 10;
		}
		if(page == null || page<1){
			page = 0;
		}
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page,pageSize);
		
		Page<User> pageUser = userService.findAllUserPage(pageable);
		
		out.setData(pageUser);
		
		return out;
	}
	
	
	
	@SuppressWarnings({"rawtypes"})
	@ApiOperation(value = "/userAuthorityManage",notes = "Manage authorities for selected user include grant and revoke")
	@RequestMapping(value = "/userAuthorityManage", method = RequestMethod.POST)
	public OutputData userAuthorityManage(@RequestBody UserAuthoityRelRequest request) {
		
		OutputData out = new OutputData().returnSuccess();
		
		List<Long> grantedAuthorityIds = request.getAuthorityIds();
		
		try {
			
			if (userService.dealUserAuthorityManage(request.getUserId(),grantedAuthorityIds)) {
				return out;
			} else {
				return out.returnFail("UserService 处理失败");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return out.returnFail(e.getMessage());
		}
		
	}
	
	
	
	
	@SuppressWarnings({"rawtypes"})
	@ApiOperation(value = "/userGroupManage",notes = "Manage groups for selected user include grant and revoke")
	@RequestMapping(value = "/userGroupManage", method = RequestMethod.POST)
	public OutputData userGroupManage(@RequestBody UserGroupRelRequest request) {
		
		OutputData out = new OutputData().returnSuccess();
		
		List<Long> grantedGroupIds = request.getGroupIds();
		
		try {
			if (userService.dealUserGroupManage(request.getUserId(),grantedGroupIds)) {
				return out;
			} else {
				return out.returnFail("UserService 处理失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
			return out.returnFail(e.getMessage());
		}
		
	}
	
	
	@SuppressWarnings({"rawtypes"})
	@RequestMapping(value = "/userFilter", method = RequestMethod.GET)
	@ApiOperation(value = "/userFilter",notes = "Filter Users")
	public OutputData userFilter(Long orgId,Long dptId,Long groupId, Long roleId, String enable,Integer pageSize,Integer page) {
		
		OutputData out = new OutputData().returnSuccess();
		
		if(pageSize == null || pageSize<1){
			pageSize = 10;
		}
		if(page == null || page<1){
			page = 0;
		}
		@SuppressWarnings("deprecation")
		Pageable pageable = new PageRequest(page,pageSize);
		
		Page<User> pageUsers = userService.findUserListByFilterCriteria(orgId,dptId,groupId, roleId,pageable);
		
		out.setData(pageUsers);
		
		return out;
	}
	
	
	
	
	
	
}
