package com.example.blog.controller;

import com.example.blog.bean.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping(value = "/home")
    public String showHome(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("blogs",blogService.findAll(pageable));
        if(blogService.findAll(pageable)==null){
            model.addAttribute("msg","Chua co bai viet nao");
        }
        return "home";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping(value = "/create")
    public String save(@ModelAttribute Blog blog, @RequestParam("img") MultipartFile img, RedirectAttributes redirectAttributes){
        if (img.isEmpty()){
            blog.setLinkImg("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = img.getInputStream();
            Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            blog.setLinkImg(img.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        blog.setDate(String.valueOf(today));

        blogService.save(blog);
        return "redirect:/home";
    }
    @GetMapping(value = "remove/{id}")
    public String remove(@PathVariable("id") Long id){
        blogService.remove(id);
        return "redirect:/home";
    }
    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/update";
    }
    @PostMapping(value = "/update")
    public String update(@ModelAttribute ("blog") Blog blog, @RequestParam("img") MultipartFile img ){
        if (img.isEmpty()){
            blog.setLinkImg("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = img.getInputStream();
            Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            blog.setLinkImg(img.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate today = LocalDate.now();

        blog.setDate(String.valueOf(today));

        blogService.save(blog);
        return "redirect:/home";
    }
    @GetMapping(value = "/search")
    public String searchContent(@RequestParam("search") String search,Model model){
       model.addAttribute("blogs", blogService.findByContent(search));
       if(blogService.findByContent(search).isEmpty()){
           model.addAttribute("msg","Khong tim thay phim lien quan");
       }else {
           model.addAttribute("msg","Khoang "+blogService.findByContent(search).size()+" ket qua duoc tim thay");
       }
       return "/home";
    }
}
