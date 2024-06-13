package com.mmdev.maindrivingschool.controller;

import com.mmdev.maindrivingschool.entity.RegistrationForm;
import com.mmdev.maindrivingschool.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody RegistrationForm form) {
		registrationService.register(form);
		return "Registration Successful!";
	}
}
