package com.example.calculate.controller;

import com.example.calculate.service.ICalculateService;
import com.example.calculate.service.impl.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCalculate {
    @Autowired
    CalculateService calculateService ;
    @GetMapping( value = "")
    public String showCalculate(){
        return "create";
    }
    @GetMapping(value = "calculate")
    public String result(@RequestParam float num1, @RequestParam float num2, @RequestParam String calculate, Model model){
        String result = null;
        switch (calculate){
            case "+":
                result= String.valueOf(calculateService.plusExpression(num1,num2));
                break;
            case "-":
                result= String.valueOf(calculateService.minusExpression(num1,num2));
                break;
            case "*":
                result= String.valueOf(calculateService.multiplicationExpression(num1,num2));
                break;
            case "/":
                result= String.valueOf(calculateService.divisionExpression(num1,num2));
                break;
        }
        model.addAttribute("result",result);
        return "create";
    }
}
