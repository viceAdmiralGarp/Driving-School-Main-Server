package com.mmdev.maindrivingschool.service;

import com.mmdev.maindrivingschool.entity.RegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	private JavaMailSender emailSender;

	public void register(RegistrationForm form) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("marchenkomatvey75@gmail.com");
		message.setSubject("New Registration");
		message.setText("Name: " + form.getFullname() + "\nEmail: " + form.getEmail() + "\nPhone: " + form.getPhone());
		emailSender.send(message);
	}
}
