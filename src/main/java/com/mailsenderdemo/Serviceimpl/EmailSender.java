package com.mailsenderdemo.Serviceimpl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail, String subject, String body, List<File> attachments) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("rahulachugatla1@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); 
            for (File file : attachments) {
                helper.addAttachment(file.getName(), file);
            }
            mailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("Error while sending mail: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
