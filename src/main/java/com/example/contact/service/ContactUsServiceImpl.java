package com.example.contact.service;

import com.example.contact.model.ContactForm;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ContactUsServiceImpl implements ContactUsService {

    @Override
    public void contact(ContactForm contactForm) {
        System.out.println(contactForm.toString());
    }
}
