package com.mmdev.maindrivingschool.controller;

import com.mmdev.maindrivingschool.entity.RegistrationForm;
import com.mmdev.maindrivingschool.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestParam("fullname") String fullname,
						   @RequestParam("email") String email,
						   @RequestParam("phone") String phone) {
		System.err.println(fullname);
		System.err.println(email);
		System.err.println(phone);
		RegistrationForm form = new RegistrationForm(fullname, email, phone);
		registrationService.register(form);
		return "Registration Successful!";
	}
}
