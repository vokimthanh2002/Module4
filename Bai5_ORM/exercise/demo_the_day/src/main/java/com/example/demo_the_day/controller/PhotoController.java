package com.example.demo_the_day.controller;

import com.example.demo_the_day.entyti.Evaluate;
import com.example.demo_the_day.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PhotoController {
    @Autowired
    PhotoRepository photoRepository;
    @GetMapping(value = "")
    public String showHome(Model model){
        model.addAttribute("evaluate",new Evaluate());
        int[] arrayStar ={1,2,3,4,5};
        model.addAttribute("arrayStar",arrayStar);
        model.addAttribute("listEvaluate",photoRepository.getAll());
        return "/home";
    }
    @GetMapping(value = "/evaluate")
    public String submitForm(@ModelAttribute("evaluate") Evaluate evaluate){
        photoRepository.addEvaluate(evaluate);
        return "redirect:/";
    }
    @GetMapping(value = "/like/{id}")
    public String like(@PathVariable("id") int id){
        Evaluate evaluate=photoRepository.findById(id);
        evaluate.setNumberOfLikes(evaluate.getNumberOfLikes()+1);
        photoRepository.update(evaluate);
        return "redirect:/";
    }
}
