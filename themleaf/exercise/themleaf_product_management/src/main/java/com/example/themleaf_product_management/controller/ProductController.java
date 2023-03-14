package com.example.themleaf_product_management.controller;

import com.example.themleaf_product_management.model.Product;
import com.example.themleaf_product_management.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
  @Autowired
    private ProductService productService;
    @GetMapping("/list")
    public String showList(Model model){
    model.addAttribute("listProduct",productService.getAll());
        return "/list";
    }
  @GetMapping("/create")
  public String showCreate(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);
    model.addAttribute("listProduct",productService.getAll());
    return "/create";
  }
  @PostMapping("/create")
  public String doCreate(@ModelAttribute(name = "product") Product product, Model model, RedirectAttributes rd) {
    productService.insertProduct(product);
    rd.addFlashAttribute("message", "Thêm mới product thành công");
    return "redirect:/list";
  }
  @GetMapping("/remove/{id}")
  public String doRemove(@PathVariable("id") int id) {
    productService.deleteProduct(id);
    return "redirect:/list";
  }
  @GetMapping("/update/{id}")
  public String showUpdateForm(Model model,@PathVariable("id") int id){
      model.addAttribute("product",productService.seeDetails(id));
      return "/update";
  }
  @PostMapping("/list")
  public String update( @ModelAttribute("product") Product product){
       productService.update(product,product.getIdSanPham());
      return "redirect:/list";
  }

  @GetMapping("/searchName")
  public String searchByName(@RequestParam("searching") String nameSearching,Model model) {
    model.addAttribute("listProduct",productService.finByName(nameSearching));
    return "/list";
  }

}
