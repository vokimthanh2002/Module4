package com.example.quanlythucung.controller;

import com.example.quanlythucung.bean.Quyen;
import com.example.quanlythucung.bean.TaiKhoan;
import com.example.quanlythucung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public  class LoginControler {
    @Autowired
    UserService service;

    @GetMapping(value = "/signup")
    public String signup(Model model){
        model.addAttribute("user",new TaiKhoan());
        return "user/signup";
    }
    @PostMapping(value = "/signup")
    public String signup(@Validated @ModelAttribute("user") TaiKhoan user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "user/signup";
        }else{
            user.setQuyen(new Quyen("rule_user","User"));
            user.setTrangThai("Mo");
            LocalTime nowT =LocalTime.now();
            LocalDate nowD =LocalDate.now();
            user.setNgayDk(String.valueOf("D: "+nowD+" T: "+nowT).substring(0,25)+" GMT+0");
            service.addUser(user);
            return "redirect:/login";
        }
    }


    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("user", new TaiKhoan());
        return "user/login";
    }
    @PostMapping(value = "/login")
    public String doLogin(@ModelAttribute("user") TaiKhoan user, Model model, HttpSession session){
        TaiKhoan userCheck =service.checkPass(user.getTenDangNhap());
        if(userCheck!=null){
            if(userCheck.getMatKhau().equals(user.getMatKhau())){
                session.setAttribute("user_logiin",userCheck);
                if(userCheck.getQuyen().getIdQuyen().equals("rule_user")){
                    return "redirect:/home";
                }else if(userCheck.getQuyen().getIdQuyen().equals("rule_cs")){
                    return "redirect:/list_nv";
                }else if(userCheck.getQuyen().getIdQuyen().equals("rule-admin")){
                    return "redirect:/list_user";
                }

            }
        }
        return "user/login";
    }

}
