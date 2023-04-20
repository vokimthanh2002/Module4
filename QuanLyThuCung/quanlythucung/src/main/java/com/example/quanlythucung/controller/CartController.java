package com.example.quanlythucung.controller;


import com.example.quanlythucung.bean.Cart;
import com.example.quanlythucung.bean.SanPham;
import com.example.quanlythucung.service.CartService;
import com.example.quanlythucung.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    CartService cartService;

    @GetMapping("")
    public String listCart(@SessionAttribute("carts") List<Cart> cartList, Model model){
        model.addAttribute("carts",cartList);
        model.addAttribute("size",cartList.size());
        model.addAttribute("totalPrice",totalPrice(cartList));
        return "cart/list";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addProductToCart(@PathVariable("id") String id,
                                   @SessionAttribute("carts") List<Cart> cartList){
        SanPham sanPham = sanPhamService.finById(id);

        if(sanPham!=null){
            if(!cartList.contains(new Cart(sanPham))){
                Cart cart = new Cart();
                cart.setSanPham(sanPham);
                cart.setQuantity(1);
                cartList.add(cart);
            } else {
                Cart cart = cartService.findBySanPham_IdSanPham(id,cartList);
                cart.setQuantity(cart.getQuantity()+1);
                cartList.set(cartService.index(id, cartList),cart);
            }
        }
        return "redirect:/cart";
    }

    @GetMapping("/remove-from-cart/{id}")
    public String removeFromCart(@PathVariable("id") String id,
                                 @SessionAttribute("carts") List<Cart> cartList ){
        SanPham sanPham = sanPhamService.finById(id);
        if(sanPham!=null) {
            Cart cart = cartService.findBySanPham_IdSanPham(id,cartList);
            if(cart.getQuantity()>0) {
                cart.setQuantity(cart.getQuantity()-1);
                cartList.set(cartService.index(id, cartList),cart);
            }
        }
        return "redirect:/cart";
    }
    @PostMapping("/buy")
    public String buy(@SessionAttribute("carts") List<Cart> cartList, HttpSession session){
        for(Cart list : cartList){
            cartService.save(list);
        }
        session.setAttribute("carts", new ArrayList<>());
        return "redirect:/cart/history";
    }

    @GetMapping("/history")
    public String historyCart(Model model,@SessionAttribute("carts") List<Cart> cartList){
        model.addAttribute("carts", cartService.findAll());
        return "cart/history";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable("id") String id,
                             @SessionAttribute("carts") List<Cart> cartList){
        cartList.remove(cartService.findBySanPham_IdSanPham(id,cartList));
        return "redirect:/cart/";
    }


    private Long totalPrice( List<Cart> cartList) {
        long total = 0;
        for(Cart list : cartList){
            total += list.getPrice();
        }
        return total;
    }
}