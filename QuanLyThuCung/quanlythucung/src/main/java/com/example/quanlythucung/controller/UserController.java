package com.example.quanlythucung.controller;

import com.example.quanlythucung.bean.DichVu;
import com.example.quanlythucung.bean.TaiKhoan;
import com.example.quanlythucung.service.DichVuService;
import com.example.quanlythucung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    DichVuService dichVuService;


    @GetMapping(value = "/home")
    public String show(HttpServletResponse response, HttpSession session,Model model){
        model.addAttribute("dichVus",dichVuService.findAllDichVu());
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        return "user/index";
    }



    @GetMapping(value = "/portfolio-details")
    public String showDetails(){
        return "user/portfolio-details";
    }
    @GetMapping(value = "/dx")
    public String dx(HttpServletResponse response, HttpSession session,Model model){
        session.removeAttribute("user_logiin");
        return "redirect:/login";
    }


    @GetMapping(value = "/contact")
    public String contact(HttpServletResponse response, HttpSession session,Model model){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        return "user/contact";
    }
    @GetMapping(value = "/services")
    public String services(HttpServletResponse response, HttpSession session,Model model){

        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("dichVus",dichVuService.findAllDichVu());
        model.addAttribute("user_logiin",user);
        return "user/services";
    }
    @GetMapping(value = "/blog")
    public String blog(HttpServletResponse response, HttpSession session,Model model){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        return "user/blog";
    }
    @GetMapping(value = "/portfolio")
    public String portfolio(HttpServletResponse response, HttpSession session,Model model){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        return "user/portfolio";
    }
    @GetMapping(value = "/pricing")
    public String pricing(HttpServletResponse response, HttpSession session,Model model){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        return "user/pricing";
    }
    @GetMapping(value = "/blog-single")
    public String blogSingle(){
        return "user/blog-single";
    }

    @GetMapping(value = "/dkdv/{idDv}")
    public String dkDv(@PathVariable("idDv") String idDv,Model model){
        DichVu dichVu = dichVuService.findByDichVuById(idDv);
        model.addAttribute("dichVu",dichVu);
        return "user/service_detail";
    }
}
