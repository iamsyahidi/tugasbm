package com.iam.tugasbm.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("dashboard")
	public String home() {
		return "dashboard/index";
	}

	@GetMapping("biodata")
	public String biodata() {
        return "biodata/index";
    }
}
