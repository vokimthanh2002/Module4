package com.example.quanlythucung.controller;

import com.example.quanlythucung.bean.*;
import com.example.quanlythucung.form.DangKiChuShopForm;
import com.example.quanlythucung.form.DangKiDichVuForm;
import com.example.quanlythucung.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Controller
@SessionAttributes("carts")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    DichVuService dichVuService;
    @Autowired
    UserService userService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    DangKiDichVuService dangKiDichVuService;
    @Autowired
    ShopService shopService;
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    KhacHangShopService khacHangShopService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ChuShopService chuShopService;

    @ModelAttribute("carts")
    public List<Cart> cartList(){
        return new ArrayList<>() ;
    }


    @GetMapping(value = "")
    public String show(HttpServletResponse response, HttpSession session,Model model,
                       @ModelAttribute("carts") List<Cart> cartList ){
        model.addAttribute("dichVus",dichVuService.findAllDichVu());
        model.addAttribute("sanPhams",sanPhamService.findAll());
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        List<Cart> cartList1 = (List<Cart>) session.getAttribute("carts");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
        model.addAttribute("user_logiin",user);
        model.addAttribute("list",cartList1);
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
    public String services(HttpServletResponse response, HttpSession session,Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        String sortField = sort.orElse("chiPhi");
        Page<DichVu> dichVus = dichVuService.findAllDichVuPage(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending()));
        model.addAttribute("dichVus", dichVus);
        int totalPages = dichVus.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (tenDangNhap == null || "".equals(tenDangNhap)) {
//            return "redirect:/login";
//        }
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
    public String portfolio(HttpServletResponse response, HttpSession session,Model model,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort,
                            @ModelAttribute("carts") List<Cart> cartList ){
        List<Cart> cartList1 = (List<Cart>) session.getAttribute("carts");
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        String sortField = sort.orElse("gia");
        Page<SanPham> sanPhams = sanPhamService.findAll(PageRequest.of(currentPage - 1, pageSize, Sort.by(sortField).descending()));
        model.addAttribute("sanPhams", sanPhams);
        model.addAttribute("list", cartList1);
        int totalPages = sanPhams.getTotalPages();
        if (totalPages > 1) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
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
        if(user!=null){
            if(user.getQuyen().getIdQuyen().equals("rule_cs")){
                return "user/Dang_ki_chu_shop_cho";
            }
        }
        return "user/pricing";
    }


    @GetMapping(value = "/blog-single")
    public String blogSingle(){
        return "user/blog-single";
    }

    @GetMapping(value = "/dv/{idDv}")
    public String dv(@PathVariable("idDv") String idDv,Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (user == null || "".equals(user)) {
//            return "redirect:/login";
//        }
        DichVu dichVu = dichVuService.findByDichVuById(idDv);
        model.addAttribute("tenChuShop",chuShopService.finBYChuShop_IdDichVu(idDv).getTenChuShop());
        model.addAttribute("dichVu",dichVu);
        model.addAttribute("user_logiin",user);
        model.addAttribute("soLuongSanPham",sanPhamService.findAll().size());
        model.addAttribute("soLuongDichVu",dichVuService.findAllDichVu().size());
        model.addAttribute("dichVus",dichVuService.findByTenDichVuContains(dichVu.getTenDichVu()));
        return "user/service_detail";
    }

    @GetMapping(value = "/sp/{idSp}")
    public String sp(@PathVariable("idSp") String idSp,Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
//        if (user == null || "".equals(user)) {
//            return "redirect:/login";
//        }
        SanPham sanPham = sanPhamService.finById(idSp);
        model.addAttribute("tenChuShop",chuShopService.finBYChuShop_IdSanPham(idSp).getTenChuShop());
        model.addAttribute("sanPham",sanPham);
        model.addAttribute("user_logiin",user);
        model.addAttribute("soLuongSanPham",sanPhamService.findAll().size());
        model.addAttribute("soLuongDichVu",dichVuService.findAllDichVu().size());
        model.addAttribute("sanPhams",sanPhamService.findByDanhMuc_IdDanhMuc(sanPham.getDanhMuc().getIdDanhMuc()));
        return "user/sanpham_detail";
    }
    @GetMapping(value = "/dkdv/{idDichVu}")
    public String dkDv(@PathVariable("idDichVu") String idDv,Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)) {
            return "redirect:/login";
        }
        DichVu dichVu = dichVuService.findByDichVuById(idDv);
        model.addAttribute("dichVu",dichVu);
        model.addAttribute("dangKiDichVuForm", new DangKiDichVuForm());
        return "user/dangkidichvu";
    }
    @PostMapping(value = "/dkdv")
    public String dkDvTc(HttpServletResponse response,
                         HttpSession session,
                         @ModelAttribute("dangKiDichVuForm") DangKiDichVuForm  dangKiDichVuForm,
                         @RequestParam("idDichVu") String idDichVu,
                         @RequestParam("chiPhi") double chiPhi){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)) {
            return "redirect:/login";
        }
        user.setQuyen(new Quyen("rule_kh","Khach Hang"));
        userService.addUser(user);

        KhachHang khachHang = new KhachHang();
        khachHang.setTaiKhoan(user);
        if(khachHangService.findByTaiKhoan_TenDangNhap(user.getTenDangNhap())==null){
            khachHang.setIdKH("KH-"+Math.random()*1000);
        }else{
            khachHang.setIdKH(khachHangService.findByTaiKhoan_TenDangNhap(user.getTenDangNhap()).getIdKH());
        }
        khachHang.setDiaChi(dangKiDichVuForm.getDiaChi());
        khachHang.setEmail(dangKiDichVuForm.getEmail());
        khachHang.setGioiTinh(dangKiDichVuForm.getGioiTinh());
        khachHang.setHoTen(dangKiDichVuForm.getHoTen());
        khachHang.setNgaySinh(dangKiDichVuForm.getNgaySinh());
        khachHang.setSdt(dangKiDichVuForm.getSdt());
        khachHangService.save(khachHang);

        DangKiDichVu dangKiDichVu = new DangKiDichVu();
        dangKiDichVu.setIdDKDV("DKDV-"+Math.random()*1000);
        dangKiDichVu.setGhiChu(dangKiDichVuForm.getGhiChu());
        dangKiDichVu.setHinhThucThanhToan(dangKiDichVuForm.getHinhThucThanhToan());
        dangKiDichVu.setSoLuong(dangKiDichVuForm.getSoLuong());
        dangKiDichVu.setThanhTien(dangKiDichVuForm.getSoLuong()*chiPhi);
        dangKiDichVu.setDichVu(dichVuService.findByDichVuById(idDichVu));
        dangKiDichVu.setNgayHen(dangKiDichVuForm.getNgayHen());
        dangKiDichVu.setKhachHang(khachHang);
        dangKiDichVu.setShop(shopService.findByIdDichVu(idDichVu));
        dangKiDichVu.setNhanVien(nhanVienService.getAllNhanVien().get(1));
        dangKiDichVuService.addDangKiDichVu(dangKiDichVu);

        KhachHangShop khachHangShop = new KhachHangShop();
        khachHangShop.setIdKhShop("KHS-"+Math.random()*1000);
        khachHangShop.setShop(shopService.findByIdDichVu(idDichVu));
        khachHangShop.setKhachHang(khachHang);
        khacHangShopService.save(khachHangShop);

        return "redirect:/";
    }

    @GetMapping(value = "/searchDichVu")
    public String searchDv(@RequestParam("inputSearchDv") String search,Model model,HttpServletResponse response,
                           HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        model.addAttribute("user_logiin",user);
        model.addAttribute("dichVus",dichVuService.findByAll(search,search,search));
        return "user/services";
    }
    // dang ki chu shop
    @GetMapping(value = "/dk_chu_shop")
    public String dkcs(Model model,HttpServletResponse response, HttpSession session){
        TaiKhoan user = (TaiKhoan) session.getAttribute("user_logiin");
        if (user == null || "".equals(user)) {
            return "redirect:/login";
        }
        model.addAttribute("dangKiChuShopForm", new DangKiChuShopForm());
        return "user/dk_chu_shop";
    }
    @GetMapping(value = "/error_404")
    public String error_404(){
        return "user/error";
    }



}
