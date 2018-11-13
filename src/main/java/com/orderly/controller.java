package com.orderly;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.orderly.service.UserServiceStub;

@Controller
public class controller {
	private UserServiceStub userService;
	
	public controller() {
		this.userService = new UserServiceStub();
	}

	@RequestMapping("/signin")
	public String start() {
		return "signin";
	}

	@RequestMapping("logout")
	public String logout() {
		return "logout";
	}

	@RequestMapping("/board")
	public String project() {
		return "board";
	}

	@RequestMapping("/signInForm")
	public String signin(@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		return "start";
	}

	@RequestMapping("/signUpForm")
	public String signup(
			@RequestParam(value = "email", required = true, defaultValue = "") String email,
			@RequestParam(value = "name", required = true, defaultValue = "") String name,
			@RequestParam(value = "password", required = true, defaultValue = "") String password) {
		this.userService.createUser(email, name, password);
		return "start";
	}
}
