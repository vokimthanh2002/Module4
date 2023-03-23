package com.example.email_configuration.controller;

import com.example.email_configuration.model.Mail;
import com.example.email_configuration.service.IMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MailController {
    @Autowired
    IMaiService iMailService;
    @GetMapping("/mail")
    public String showMail(Model model){
        model.addAttribute("email",new Mail());
        String[] languages = {"English","Vietnamese", "Japanese","Chinese"};
        Integer[] pageSizes = {5,10,15,50,25,100};
        model.addAttribute("languages",languages);
        model.addAttribute("pageSizes",pageSizes);
        return "setting";
    }

    @PostMapping("/getmail")
    public String getEmail(@ModelAttribute("mail")Mail mail, Model model, RedirectAttributes redirectAttributes){

        model.addAttribute("email", new Mail("1",2,"3","4"));
        return "setting";
    }
}