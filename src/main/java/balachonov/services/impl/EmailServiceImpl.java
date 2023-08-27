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

    private final JavaMailSender EMAIL_SENDER;

    @Override
    public void sendSuccessfulBasketMail(String email) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(COMPANY_GMAIL);
            mailMessage.setTo(email);
            mailMessage.setText(MESSAGE_BASKET);
            mailMessage.setSubject(SUBJECT_BASKET);
            EMAIL_SENDER.send(mailMessage);
    }

    @Override
    public void sendSuccessfulRegistrationMail(String email) {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(COMPANY_GMAIL);
            mailMessage.setTo(email);
            mailMessage.setText(MESSAGE_SUCCESSFUL_REGISTRATION);
            mailMessage.setSubject(SUBJECT_SUCCESSFUL_REGISTRATION);
            EMAIL_SENDER.send(mailMessage);
    }
}