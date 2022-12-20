package com.netflix.backend.services.implementation;

import com.netflix.backend.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImplementation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    private String sender = System.getenv("email");
    public void sendSimpleMail(final String toEmail, final String subject, final String content){
        try {
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            mailMessage.setFrom(sender);
            mailMessage.setTo(toEmail);
            mailMessage.setText(content);
            mailMessage.setSubject(subject);
            javaMailSender.send(mailMessage);
            System.out.println("Otp Sent Successfully...");
        }
        catch (Exception e) {
            System.out.println("Error while Sending Mail");
        }
    }
}
