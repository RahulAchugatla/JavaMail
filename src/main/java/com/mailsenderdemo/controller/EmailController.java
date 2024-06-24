package com.mailsenderdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailsenderdemo.Serviceimpl.EmailSender;

@RestController
public class EmailController {
	
    @Autowired
    private EmailSender emailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        String to ="rahulachugatla5@gmail.com";
        String subject = "Hello from Spring Boot!";
        String body = "This is a test email sent using Spring Boot.";

        emailService.sendMail(to, subject, body);
        return "Email sent successfully!";
    }
}
