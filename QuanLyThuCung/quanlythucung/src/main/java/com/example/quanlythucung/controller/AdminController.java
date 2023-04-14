package com.example.quanlythucung.controller;

import com.example.quanlythucung.bean.ChuShop;
import com.example.quanlythucung.bean.Shop;
import com.example.quanlythucung.bean.TaiKhoan;
import com.example.quanlythucung.service.ChuShopService;
import com.example.quanlythucung.service.ShopService;
import com.example.quanlythucung.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    UserService userService;
    @Autowired
    ChuShopService chuShopService;
    @Autowired
    ShopService shopService;

    @GetMapping(value = "/list_user")
    public String showListUser(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        List<TaiKhoan> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "admin/list_user";
    }
    @GetMapping(value = "/list_cs")
    public String showListCs(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        List<ChuShop> chuShops = chuShopService.findAllChuShop();
        model.addAttribute("chuShops",chuShops);
        return "admin/list_cs";
    }

    @GetMapping(value = "/list_shop")
    public String showListShop(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        List<Shop> shops = shopService.findAllShop();
        model.addAttribute("shops",shops);
        return "admin/list_shop";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") String tenDangNhap, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        TaiKhoan userDelete = userService.finById(tenDangNhap);
        userService.deleteUser(userDelete);
        return "redirect:/list_user";
    }

    @GetMapping(value = "/open/{id}")
    public String openUser(@PathVariable("id") String tenDangNhap, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        TaiKhoan userOpen = userService.finById(tenDangNhap);
        userOpen.setTrangThai("Mo");
        userService.updateUser(userOpen);
        return "redirect:/list_user";
    }

    @GetMapping(value = "/block/{id}")
    public String blockUser(@PathVariable("id") String tenDangNhap, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/login";
        }
        TaiKhoan userBlock = userService.finById(tenDangNhap);
        userBlock.setTrangThai("Khoa");
        userService.updateUser(userBlock);
        return "redirect:/list_user";
    }


}
