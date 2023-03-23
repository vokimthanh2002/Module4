package com.example.photo_of_the_day_spring_boot.controller;

import com.example.photo_of_the_day_spring_boot.entyti.Evaluate;
import com.example.photo_of_the_day_spring_boot.repository.PhotoRepository;
import com.example.photo_of_the_day_spring_boot.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PhotoController {
    @Autowired
    PhotoService photoService;
    @GetMapping(value = "")
    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        String sortField = sort.orElse("numberOfLikes");
//        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
        Page<Evaluate> evaluates = photoService.findAllWithPaging(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending()));
        model.addAttribute("evaluates", evaluates);
        model.addAttribute("evaluate", new Evaluate());
        int totalPages = evaluates.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "home";
    }
    @PostMapping(value = "/evaluate")
    public String submitForm(@ModelAttribute("evaluate") Evaluate evaluate){
        photoService.addEvaluate(evaluate);
        return "redirect:/";
    }
    @GetMapping(value = "/like/{id}")
    public String like(@PathVariable("id") int id){
        Evaluate evaluate=photoService.findById(id);
        evaluate.setNumberOfLikes(evaluate.getNumberOfLikes()+1);
        photoService.update(evaluate);
        return "redirect:/";
    }
}


