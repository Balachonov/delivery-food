package balachonov.services.impl;

import balachonov.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static balachonov.util.Constants.*;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendSuccessfulOrderMail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${spring.mail.username}");
        mailMessage.setTo(email);
        mailMessage.setText(MESSAGE_ORDER);
        mailMessage.setSubject(SUBJECT_ORDER);
        mailSender.send(mailMessage);
    }

    @Override
    public void sendSuccessfulRegistrationMail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("${spring.mail.username}");
        mailMessage.setTo(email);
        mailMessage.setText(MESSAGE_SUCCESSFUL_REGISTRATION);
        mailMessage.setSubject(SUBJECT_SUCCESSFUL_REGISTRATION);
        mailSender.send(mailMessage);
    }
}