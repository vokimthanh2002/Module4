package com.example.dapm_quan_ly_thu_cung_nhom_27.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value="")
    public String login(){
        return "login";
    }
}
