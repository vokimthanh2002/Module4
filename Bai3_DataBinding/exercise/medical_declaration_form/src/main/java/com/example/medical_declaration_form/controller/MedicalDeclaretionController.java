package com.example.medical_declaration_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MedicalDeclaretionController {
    @GetMapping("/showForm")
    public String showForm(){
        return "form_medical_declaration";
    }

}
