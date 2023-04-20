package com.example.quanlythucung.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bill")
    private Integer idCart;

    @ManyToOne
    @JoinColumn(name = "idSanPham")
    private SanPham sanPham;
    private Integer quantity;

    public Cart() {
    }

    public Cart(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void deleteProduct(){
        quantity--;
    }

    public void addProduct(){
        quantity++;
    }

    public double getPrice() {
        return sanPham.getGia() * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return sanPham.getIdSanPham().equals(cart.sanPham.getIdSanPham());
    }

    @Override
    public int hashCode() {
        return Objects.hash(sanPham);
    }
}
