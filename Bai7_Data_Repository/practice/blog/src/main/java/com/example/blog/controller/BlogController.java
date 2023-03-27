package com.example.blog.controller;

import com.example.blog.bean.Blog;
import com.example.blog.bean.Category;
import com.example.blog.service.BlogService;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;
//    @GetMapping(value = "/home")
//    public String showHome(Model model, @PageableDefault(value = 5) Pageable pageable){
//        model.addAttribute("blogs",blogService.findAll(pageable));
//        if(blogService.findAll(pageable)==null){
//            model.addAttribute("msg","Chua co bai viet nao");
//        }
//        return "home";
//    }
@ModelAttribute("categories")
public Iterable<Category> categories(){
    return categoryService.findAll();
}

    @GetMapping(value = "/home")
    public String listpaging(Model model, @RequestParam("page") Optional<Integer> page,
                             @RequestParam("size") Optional<Integer> size,
                             @RequestParam("sort") Optional<String> sort) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
//        Sort sortBy = Sort.by("email").descending().and(Sort.by("phoneNumber").ascending());
        Page<Blog> blogs = blogService.findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending()));
        model.addAttribute("blogs", blogs);
        int totalPages = blogs.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "blog/home";
    }
    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories",categoryService.findAll());
        return "blog/create";
    }


    @PostMapping(value = "/create")
    //loi qq gi ko hieu
    public String save(@Validated  @ModelAttribute Blog blog, @RequestParam("img") MultipartFile img, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "blog/create";
        }else{
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
    }
    @GetMapping(value = "remove/{id}")
    public String remove(@PathVariable("id") Long id){
        blogService.remove(id);
        return "redirect:/home";
    }
    @GetMapping(value = "update/{id}")
    public String showUpdate(@PathVariable("id") Long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categories",categoryService.findAll());
        return "blog/update";
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
       return "blog/home";
    }
    @GetMapping(value = "category/{id}")
    public String listCategory(@PathVariable("id") Long id,Model model){
            model.addAttribute("blogs",blogService.findByCategory_Id(id));
             return "blog/home";
    }
}
