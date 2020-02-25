package yorms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/regulation")
public class RegulationController {
	
	@RequestMapping(value = "/regulationAdd", method = RequestMethod.GET)
	public String organizationAddForm(){
		return "regulation/regulationAdd";
	}

}
