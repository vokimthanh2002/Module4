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
            return "redirect:/error_404";
        }
        List<TaiKhoan> users = userService.getAllUser();
        model.addAttribute("users",users);
        return "admin/list_user";
    }
    @GetMapping(value = "/list_cs")
    public String showListCs(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/error_404";
        }
        List<ChuShop> chuShops = chuShopService.findAllChuShop();
        model.addAttribute("chuShops",chuShops);
        return "admin/list_cs";
    }

    @GetMapping(value = "/list_shop")
    public String showListShop(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/error_404";
        }
        List<Shop> shops = shopService.findByTrangThai("Da duyet");
        model.addAttribute("shops",shops);
        return "admin/list_shop";
    }

    @GetMapping(value = "/list_shop_cho_duyet")
    public String showListShopChoDuyet(Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/error_404";
        }
        List<Shop> shops = shopService.findByTrangThai("Chua duyet");
        model.addAttribute("shops",shops);
        return "admin/list_shop_cd";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") String tenDangNhap, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/error_404";
        }
        TaiKhoan userDelete = userService.finById(tenDangNhap);
        userService.deleteUser(userDelete);
        return "redirect:/list_user";
    }

    @GetMapping(value = "/open/{id}")
    public String openUser(@PathVariable("id") String tenDangNhap, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule-admin")) {
            return "redirect:/error_404";
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
            return "redirect:/error_404";
        }
        TaiKhoan userBlock = userService.finById(tenDangNhap);
        userBlock.setTrangThai("Khoa");
        userService.updateUser(userBlock);
        return "redirect:/list_user";
    }
    @GetMapping(value = "/duyetshop/{id}")
    public String duyetShop(@PathVariable("id") String id,Model model){
        model.addAttribute("shop",shopService.findById(id));
        return "admin/profile_cs";
    }

}
