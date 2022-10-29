package com.example.contact.controller;

import com.example.contact.model.ContactForm;
import com.example.contact.service.ContactUsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
@RequiredArgsConstructor
public class ContactUsControllerImpl implements ContactUsController {

    @Autowired
    private ContactUsService service;

    @Override
    public String displayForm(ContactForm contactForm) {
        return "contact";
    }

    @Override
    public String contact(ContactForm contactForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "contact";
        }

        service.contact(contactForm);
        return "redirect:/summary?name=" + contactForm.getName();
    }

    @Override
    public String summary(String name) {
        return "summary";
    }

}
