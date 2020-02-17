package yorms.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import yorms.pojo.user.Authority;
import yorms.pojo.user.GroupM;
import yorms.pojo.user.User;
import yorms.service.UserService;

import java.util.List;
import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showUserProfile(Model model) {
		return "user/profile";
	}

	@RequestMapping(value = "/permission", method = RequestMethod.GET)
	public String showPermissionManage(Model model) {
		return "user/permission";
	}

	@RequestMapping(value = "/groupAdd", method = RequestMethod.GET)
	public String groupAdd(Model model) {
		return "user/groupAdd";
	}

	@RequestMapping(value = "/groupManage", method = RequestMethod.GET)
	public String showGroupManage(Model model,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

		Page<GroupM> pageGroupMs = userService.findAllGroupMPage(pageable);
		model.addAttribute("groupMs", pageGroupMs);
		model.addAttribute("totalElements", pageGroupMs.getTotalElements());
		model.addAttribute("size", pageGroupMs.getSize());
		model.addAttribute("totalPages", pageGroupMs.getTotalPages());
		model.addAttribute("currentPage", pageGroupMs.getNumber());
		model.addAttribute("sort", pageGroupMs.getSort());

		return "user/groupManage";
	}

	@RequestMapping(value = "/groupAdd", method = RequestMethod.POST)
	public String groupAddSave(Model model, GroupM groupM,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		userService.save(groupM);
		Page<GroupM> pageGroupMs = userService.findAllGroupMPage(pageable);
		model.addAttribute("groupMs", pageGroupMs);
		model.addAttribute("totalElements", pageGroupMs.getTotalElements());
		model.addAttribute("size", pageGroupMs.getSize());
		model.addAttribute("totalPages", pageGroupMs.getTotalPages());
		model.addAttribute("currentPage", pageGroupMs.getNumber());
		model.addAttribute("sort", pageGroupMs.getSort());
		return "user/groupManage";
	}

	@RequestMapping(value = "/groupEdit", method = RequestMethod.GET)
	public String groupEdit(Model model, Long id, Integer currentPage, Integer size) {
		GroupM groupM = userService.findGroupMById(id);
		model.addAttribute("groupM", groupM);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("size", size);
		return "user/groupMod";
	}

	@RequestMapping(value = "/groupEdit", method = RequestMethod.POST)
	public String groupEditSave(Model model, GroupM groupM,@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		
		GroupM groupMForUpdate = userService.findGroupMById(groupM.getId());
		groupMForUpdate.setGroupName(groupM.getGroupName());
		groupMForUpdate.setGroupDesc(groupM.getGroupDesc());
		userService.save(groupMForUpdate);
		
		Page<GroupM> pageGroupMs = userService.findAllGroupMPage(pageable);
		model.addAttribute("groupMs", pageGroupMs);
		model.addAttribute("totalElements", pageGroupMs.getTotalElements());
		model.addAttribute("size", pageGroupMs.getSize());
		model.addAttribute("totalPages", pageGroupMs.getTotalPages());
		model.addAttribute("currentPage", pageGroupMs.getNumber());
		model.addAttribute("sort", pageGroupMs.getSort());
		return "user/groupManage";
	}

	@RequestMapping(value = "/groupAuthorityGrant", method = RequestMethod.GET)
	public String groupAuthorityGrant(Model model, Long id, Integer currentPage, Integer size) {
		GroupM groupM = userService.findGroupMById(id);
		model.addAttribute("groupM", groupM);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("size", size);
		return "user/groupAuthorityGrant";
	}

	@RequestMapping(value = "/groupAuthorityGrant", method = RequestMethod.POST)
	public String groupAuthorityGrantSave(Model model, @RequestBody JSONObject jsonParam) {
		userService.dealGroupAuthorityGrantJSON(jsonParam);
		return "user/groupManage";
	}

	@RequestMapping(value = "/roleAdd", method = RequestMethod.GET)
	public String roleAdd(Model model) {
		return "user/roleAdd";
	}

	@RequestMapping(value = "/roleManage", method = RequestMethod.GET)
	public String showRoleManage(Model model,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

		Page<Authority> pageAuthorities = userService.findAllAuthorityPage(pageable);
		model.addAttribute("authorities", pageAuthorities);
		model.addAttribute("totalElements", pageAuthorities.getTotalElements());
		model.addAttribute("size", pageAuthorities.getSize());
		model.addAttribute("totalPages", pageAuthorities.getTotalPages());
		model.addAttribute("currentPage", pageAuthorities.getNumber());
		model.addAttribute("sort", pageAuthorities.getSort());
		return "user/roleManage";
	}

	@RequestMapping(value = "/roleAdd", method = RequestMethod.POST)
	public String roleAddSave(Model model, Authority authority,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		userService.save(authority);
		Page<Authority> pageAuthorities = userService.findAllAuthorityPage(pageable);
		model.addAttribute("authorities", pageAuthorities);
		model.addAttribute("totalElements", pageAuthorities.getTotalElements());
		model.addAttribute("size", pageAuthorities.getSize());
		model.addAttribute("totalPages", pageAuthorities.getTotalPages());
		model.addAttribute("currentPage", pageAuthorities.getNumber());
		model.addAttribute("sort", pageAuthorities.getSort());
		return "user/roleManage";
	}

	@RequestMapping(value = "/roleEdit", method = RequestMethod.GET)
	public String roleEdit(Model model, Long id, Integer currentPage, Integer size) {
		Authority authority = userService.findAuthorityById(id);
		model.addAttribute("authority", authority);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("size", size);
		return "user/roleMod";
	}

	@RequestMapping(value = "/roleEdit", method = RequestMethod.POST)
	public String roleEditSave(Model model, Authority authority,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		userService.save(authority);
		Page<Authority> pageAuthorities = userService.findAllAuthorityPage(pageable);
		model.addAttribute("authorities", pageAuthorities);
		model.addAttribute("totalElements", pageAuthorities.getTotalElements());
		model.addAttribute("size", pageAuthorities.getSize());
		model.addAttribute("totalPages", pageAuthorities.getTotalPages());
		model.addAttribute("currentPage", pageAuthorities.getNumber());
		model.addAttribute("sort", pageAuthorities.getSort());
		return "user/roleManage";
	}

	@RequestMapping(value = "/userAdd", method = RequestMethod.GET)
	public String userAdd(Model model) {
		return "user/userAdd";
	}

	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String userAddSave(Model model, @RequestBody JSONObject jsonParam,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

		userService.dealUserAddJSON(jsonParam);
		Page<User> pageUsers = userService.findAllUserPage(pageable);
		model.addAttribute("users", pageUsers);
		model.addAttribute("totalElements", pageUsers.getTotalElements());
		model.addAttribute("size", pageUsers.getSize());
		model.addAttribute("totalPages", pageUsers.getTotalPages());
		model.addAttribute("currentPage", pageUsers.getNumber());
		model.addAttribute("sort", pageUsers.getSort());
		return "user/userManage";
	}

	@RequestMapping(value = "/userManage", method = RequestMethod.GET)
	public String showUserManage(Model model,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

		Page<User> pageUsers = userService.findAllUserPage(pageable);
		
		model.addAttribute("users", pageUsers);
		model.addAttribute("totalElements", pageUsers.getTotalElements());
		model.addAttribute("size", pageUsers.getSize());
		model.addAttribute("totalPages", pageUsers.getTotalPages());
		model.addAttribute("currentPage", pageUsers.getNumber());
		model.addAttribute("sort", pageUsers.getSort());
		return "user/userManage";

	}

	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String editUser(Model model, Long id, Integer currentPage, Integer size) {

		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("size", size);
		return "user/userMod";
	}

	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public String editUserSave(Model model, @RequestBody JSONObject jsonParam) {
		userService.dealUserEditJSON(jsonParam);

		/*
		 * Sort sort = new Sort(Direction.DESC, "id"); int page =
		 * jsonParam.getIntValue("page"); int size = jsonParam.getIntValue("size");
		 * Pageable pageable = PageRequest.of(page, size, sort); Pageable pageable = new
		 * PageRequest(page, size, sort); Page<User> pageUsers =
		 * userService.findAllUserPage(pageable); model.addAttribute("users",
		 * pageUsers); model.addAttribute("totalElements",
		 * pageUsers.getTotalElements()); model.addAttribute("size",
		 * pageUsers.getSize()); model.addAttribute("totalPages",
		 * pageUsers.getTotalPages()); model.addAttribute("currentPage",
		 * pageUsers.getNumber()); model.addAttribute("sort", pageUsers.getSort());
		 */
		return "user/userManage";
	}

	@RequestMapping(value = "/userDel", method = RequestMethod.GET)
	public String delUser(Model model, Long id,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
		userService.deleteUser(id);

		Page<User> pageUsers = userService.findAllUserPage(pageable);
		model.addAttribute("users", pageUsers);
		model.addAttribute("totalElements", pageUsers.getTotalElements());
		model.addAttribute("size", pageUsers.getSize());
		model.addAttribute("totalPages", pageUsers.getTotalPages());
		model.addAttribute("currentPage", pageUsers.getNumber());
		model.addAttribute("sort", pageUsers.getSort());
		return "user/userManage";

	}

	@RequestMapping(value = "/userFilter", method = RequestMethod.GET)
	public String userFilter(Model model, Long groupId, Long roleId, String enable,
			@PageableDefault(value = 10, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

		model.addAttribute("groupIdFilterCriteria", groupId);
		model.addAttribute("roleIdFilterCriteria", roleId);
		model.addAttribute("enableFilterCriteria", enable);
		model.addAttribute("pageFunction", "user/userFilter");

		Page<User> pageUsers = userService.findUserListByFilterCriteria(groupId, roleId, enable, pageable);
		model.addAttribute("users", pageUsers);
		model.addAttribute("totalElements", pageUsers.getTotalElements());
		model.addAttribute("size", pageUsers.getSize());
		model.addAttribute("totalPages", pageUsers.getTotalPages());
		model.addAttribute("currentPage", pageUsers.getNumber());
		model.addAttribute("sort", pageUsers.getSort());
		return "user/userManage";

	}

	/**
	 * Controller 处理groupJSON请求
	 * 
	 * @author Crescent
	 */
	@RequestMapping(value = "/groupJSON", method = RequestMethod.GET)
	@ResponseBody
	public List<GroupM> groupJSON() {
		return userService.getGroupMList();
	}

	/**
	 * Controller 处理groupJSON请求
	 * 
	 * @author Crescent
	 */
	@RequestMapping(value = "/roleJSON", method = RequestMethod.GET)
	@ResponseBody
	public List<Authority> roleJSON() {
		return userService.getAuthoriytList();
	}

}
