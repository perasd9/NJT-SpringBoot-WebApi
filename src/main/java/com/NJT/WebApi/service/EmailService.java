package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Rezervacija;
import com.NJT.WebApi.model.exception.EmailFailureException;
import com.NJT.WebApi.model.VerificationToken;
import com.NJT.WebApi.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${email.from}")
    private String fromEmail;

    @Value("${app.frontend.url}")
    private String frontendUrl;


    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    private SimpleMailMessage makeMailMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        return message;
    }

    public void sendVerificationEmail(VerificationToken verificationToken) throws EmailFailureException {
        SimpleMailMessage message = makeMailMessage();
        message.setTo(verificationToken.getUser().getEmail());
        message.setSubject("Verifikuj mail adresu za nalog.");
        message.setText("Klikni link ispod da verifikujes nalog\n" +
                frontendUrl+ "/auth/verify?token=" + verificationToken.getToken());
        try{
            javaMailSender.send(message);
        }catch(MailException e){
            throw new EmailFailureException(e.getMessage());
        }
    }

    public void posaljiMailZaRezervaciju(String subject, String text, String email) throws EmailFailureException {

        SimpleMailMessage message = makeMailMessage();
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //message.setTo(user.getEmail());

        message.setTo(email);
        
        message.setSubject(subject);
        message.setText(text);
        try{
            javaMailSender.send(message);
        }catch(MailException e){
            throw new EmailFailureException(e.getMessage());
        }
    }
}
