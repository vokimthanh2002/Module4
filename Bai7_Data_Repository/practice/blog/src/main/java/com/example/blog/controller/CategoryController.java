package com.example.blog.controller;

import com.example.blog.bean.Category;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping(value = "/list_category")
    public String showCategory(Model model){
        model.addAttribute("categories",categoryService.findAll());
        return "category/list_category";
    }
    @GetMapping(value = "/create_category")
    public String showCreateCategory(Model model){
        model.addAttribute("category", new Category());
        return "category/create_category";
    }
    @PostMapping(value = "/create_category")
    public String createCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/list_category";

    }
    @GetMapping("/update_category/{id}")
    public String showUpdateCategory(Model model, @PathVariable("id") Long id){
        Category category =categoryService.findById(id);
        model.addAttribute("category",category);
        return "category/update_category";
    }
    @PostMapping(value = "update_category")
    public String updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/list_category";
    }
    @GetMapping(value = "delete_category/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.remove(id);
        return "redirect:/list_category";
    }
}
