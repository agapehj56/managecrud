package com.example.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	static Log log = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/login")
	public String loginForm(){
		log.info("loginForm()");
		
		return "auth/loginForm";
	}
}
