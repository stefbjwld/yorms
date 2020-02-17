package yorms.web;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;


import yorms.pojo.Organization;
import yorms.service.OrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {

	@Resource
	OrganizationService organizationService;

	/**
	 * Controller 处理组织结构树请求
	 * 
	 * @author Crescent
	 */
	@RequestMapping(value = "/organizationJSON", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray organizationJSON() {
		return organizationService.getOrgsTreeviewJSON();
	}
	
	
	@RequestMapping(value = "/organizationTree", method = RequestMethod.GET)
	public String organizationTreeView() {
		return "organization/organizationTree";
	}
	
	
	@RequestMapping(value = "/organizationAdd", method = RequestMethod.GET)
	@ResponseBody
	public String organizationAdd(Organization orgForAdd,Long parentId){
		try {
			Organization parent = organizationService.findById(parentId);
			organizationService.addChildOrg(parent, orgForAdd);
			
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}
		
	}
	
	
	@RequestMapping(value = "/organizationAddForm", method = RequestMethod.GET)
	public String organizationAddForm(){
		return "organization/organizationAdd";
	}
	
	
	@RequestMapping(value = "/organizationEdit", method = RequestMethod.GET)
	public String organizationEdit(Model model,long id){
		Organization organizationForEdit = organizationService.findById(id);
		model.addAttribute("organization", organizationForEdit);
		return "organization/organizationEdit";
	}
	
	
	@RequestMapping(value = "/organizationEditSave", method = RequestMethod.GET)
	@ResponseBody
	public String organizationEditSave(Organization orgForEdit){
		try {
			Organization organizationForSave = organizationService.findById(orgForEdit.getId());
			organizationForSave.setName(orgForEdit.getName());
			organizationForSave.setOrganization_code(orgForEdit.getOrganization_code());
			organizationForSave.setOrgDesc(orgForEdit.getOrgDesc());
			organizationService.save(organizationForSave);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}
		
	}
	
	
	
	@RequestMapping(value = "/organizationDel", method = RequestMethod.GET)
	@ResponseBody
	public String organizationDel(long id){
		try {
			organizationService.deleteOrg(id);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "failed";
		}
		
	}
	
	
	@RequestMapping(value = "/organizationGenealogyPath", method = RequestMethod.GET)
	@ResponseBody
	public String getNodeGenealogyPath(Long id) {
		Organization nodeSelected = organizationService.findById(id);
		List<Organization> nodeList = organizationService.getOrgPath(nodeSelected);
		String path = "";
		for (Organization organization : nodeList) {
			path += organization.getName() + "/";
		}
		path += nodeSelected.getName();
		
		return path;
	}
	
}
