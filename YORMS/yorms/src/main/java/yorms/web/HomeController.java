package yorms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	 	@RequestMapping("/")
	    public String index() {
	        //return "redirect:/list";
	        return "home";
	    }
	    
	 	
	 	@RequestMapping("/overview/overview")
	    public String overView() {
	        //return "redirect:/list";
	        return "overview/overview";
	    }
	 	
	 	@RequestMapping("/organization/organization")
	    public String organization() {
	        //return "redirect:/list";
	        return "organization/organization";
	    }
	 	
	 	@RequestMapping("/regulation/regulation")
	    public String regulation() {
	        //return "redirect:/list";
	        return "regulation/regulation";
	    }
}
