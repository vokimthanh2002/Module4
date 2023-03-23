package com.example.currency_converter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {

    @GetMapping("/exchange")
    public String getChange( ){
        return "/USD";
    }

    @GetMapping("/currency")
    public String covertCurency(@RequestParam float usd, Model model ){
        float change = usd * 23000;
        model.addAttribute("change", change);
        return "/USD";
    }
}