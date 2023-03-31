package com.example.validate_form.controller;

import com.example.validate_form.bean.User;
import com.example.validate_form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping(value = "")
    public String showCreate(Model model){
        model.addAttribute("user",new User());
        return "/index";
    }

    @PostMapping(value = "/create")
    public String doCreate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "/index";
        }else{
            userService.save(user);
            model.addAttribute("user",user);
            return "/result";
        }

    }
}
