package com.example.contact.service;

import com.example.contact.model.ContactForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private final JavaMailSender javaMailSender;

    @Override
    public void contact(ContactForm contactForm) {
        //contact form is stored and confirmation mail is sent
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@example.com");
        message.setTo(contactForm.getEmail());
        message.setSubject("Contact");
        message.setText("Thank you for contacting us, Example Team");
        try {
            javaMailSender.send(message);
            log.info("Message was send successfully to {}", contactForm.getEmail());
        } catch (MailException ex) {
            log.error("Failed to send message: {}", ex.getMessage());
        }
    }
}
