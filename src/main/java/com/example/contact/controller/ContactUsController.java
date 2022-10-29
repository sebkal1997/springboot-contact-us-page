package com.example.contact.controller;

import com.example.contact.model.ContactForm;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContactUsController {

    @GetMapping("/")
    String displayForm(ContactForm contactForm);

    @PostMapping("/contact")
    String contact(@Valid ContactForm contactForm, BindingResult result, Model model);

    @GetMapping("/summary")
    String summary(@RequestParam("name") String name);
}
