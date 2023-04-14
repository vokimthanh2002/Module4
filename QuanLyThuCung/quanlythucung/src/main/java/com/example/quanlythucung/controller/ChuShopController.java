package com.example.quanlythucung.controller;

import com.example.quanlythucung.bean.*;
import com.example.quanlythucung.service.*;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping(value = "/cs")
public class ChuShopController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    ShopService shopService;
    @Autowired
    DichVuService dichVuService;
    @Autowired
    DangKiDichVuService dangKiDichVuService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    UserService userService;
    @Autowired
    ChuShopService chuShopService;
    @Autowired
    QuyenService quyenService;
    @GetMapping(value = "/list_nv")
    public String showListNv( Model model, HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        List<NhanVien> nhanViens = nhanVienService.findByShop_ChuShop_TaiKhoan_TenDangNhap(user.getTenDangNhap());
        model.addAttribute("nhanViens",nhanViens);
        model.addAttribute("user_logiin",user);
        return "chushop/list_nv";

    }

    @GetMapping(value = "/list_dv")
    public String showListDv(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        List<DichVu> dichVus = dichVuService.findByShop_ChuShop_TaiKhoan_TenDangNhap(user.getTenDangNhap());
        model.addAttribute("user_logiin",user);
        model.addAttribute("dichVus",dichVus);
        return "chushop/list_dv";

    }

    @GetMapping(value = "/list_dkdv")
    public String showListDkdv(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        List<DangKiDichVu> dangKiDichVus = dangKiDichVuService.findByShop_ChuShop_TaiKhoan_TenDangNhap(user.getTenDangNhap());
        model.addAttribute("user_logiin",user);
        model.addAttribute("dangKiDichVus",dangKiDichVus);
        return "chushop/list_dkdv";

    }
    @GetMapping(value = "/list_kh")
    public String showListKh(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        List<KhachHang> khachHangs = khachHangService.findByListKhachHang(user.getTenDangNhap());
        model.addAttribute("user_logiin",user);
        model.addAttribute("khachHangs",khachHangs);
        return "chushop/list_kh";

    }

    @GetMapping(value = "/create_nv")
    public String showFormCreate(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        model.addAttribute("nhanVien",new NhanVien());
        List<Quyen> chucVu = new ArrayList<>();
        for(Quyen q: quyenService.findAllQuyen()){
            if(q.getIdQuyen().equals("rule_nvcs")||q.getIdQuyen().equals("rule_nvgd")){
                chucVu.add(q);
            }
        }
        model.addAttribute("chucVu",chucVu);
        return "chushop/create_nv";
    }
    @PostMapping("/create_nv")
    public String createNv(@ModelAttribute("nhanVien") NhanVien nhanVien,
                           @RequestParam("tenDangNhap") String tenDangNhap,
                           @RequestParam("password") String password,
                           @RequestParam("chucVu") String chucVu,
                           HttpServletResponse response, HttpSession session){
        TaiKhoan user_cs = (TaiKhoan) session.getAttribute("user_logiin");
        TaiKhoan user = new TaiKhoan();
        user.setTenDangNhap(tenDangNhap);
        user.setMatKhau(password);
        user.setTrangThai("Mo");
        user.setQuyen(quyenService.finById(chucVu));
        LocalTime nowT =LocalTime.now();
        LocalDate nowD =LocalDate.now();
        user.setNgayDk(String.valueOf("D: "+nowD+" T: "+nowT).substring(0,25)+" GMT+0");
        userService.addUser(user);
        nhanVien.setIdNV("NV-"+Math.random()*10000);
        nhanVien.setTaiKhoan(user);
        Shop shop=  shopService.findByChuShop_TaiKhoan_TenDangNhap(user_cs.getTenDangNhap());
        nhanVien.setShop(shop);
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/list_kh";
    }

    @GetMapping(value = "/create_dv")
    public String showFormCreateDv(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)||!user.getQuyen().getIdQuyen().equals("rule_cs")) {
            return "redirect:/login";
        }
        model.addAttribute("dichVu",new DichVu());
        return "chushop/create_dv";
    }

    @PostMapping(value = "/create_dv")
    public String createDv(@ModelAttribute("dichVu") DichVu dichVu,
                           HttpServletResponse response,
                           HttpSession session,
                           @RequestParam("img") MultipartFile img){
        if (img.isEmpty()){
            dichVu.setLinkImg("");
        }
        Path path = Paths.get("upload/");
        try{
            InputStream inputStream = img.getInputStream();
            Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            dichVu.setLinkImg(img.getOriginalFilename().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
        TaiKhoan user_cs = (TaiKhoan) session.getAttribute("user_logiin");
        Shop shop=  shopService.findByChuShop_TaiKhoan_TenDangNhap(user_cs.getTenDangNhap());
        dichVu.setIdDichVu("DV-"+Math.random()*10000);
        dichVu.setShop(shop);
        dichVuService.addDichVu(dichVu);
        return "redirect:/list_dv";

    }

}
