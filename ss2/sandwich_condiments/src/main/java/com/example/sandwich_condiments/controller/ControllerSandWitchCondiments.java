package com.example.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ControllerSandWitchCondiments {

    @GetMapping("/create")
    public String createCondiments(){
        return "create";
    }

    @PostMapping("/list")
    public String listCondiments(@RequestParam String[] condiments, Model model){
        model.addAttribute("condiments",condiments);
        return "list";
    }
}
