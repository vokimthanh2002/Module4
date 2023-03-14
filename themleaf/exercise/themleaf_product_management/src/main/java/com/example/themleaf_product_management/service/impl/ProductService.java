package com.example.themleaf_product_management.service.impl;

import com.example.themleaf_product_management.model.Product;
import com.example.themleaf_product_management.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements IProductService {
    public static List<Product> productList = new ArrayList<>();
    static {
        //int idSanPham, String tenSanPham, Double gia, int soLuong, String mauSac, String moTa
        productList.add(new Product(1,"Phone",12000.0,12,"blue","new"));
        productList.add(new Product(2,"TiVi",12000.0,12,"blue","new"));
        productList.add(new Product(3,"Camera",12000.0,12,"blue","new"));
        productList.add(new Product(4,"Radio",12000.0,12,"blue","new"));
    }
    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void insertProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void update(Product product,int id) {
       for(int i=0;i<productList.size();i++ ){
           if(productList.get(i).getIdSanPham()==id){
               productList.set(i,product);
           }
       }
    }

    @Override
    public void deleteProduct(int id) {
        for(Product product: productList){
            if(product.getIdSanPham()==id){
                productList.remove(product);
                break;
            }
        }
    }

    @Override
    public Product seeDetails(int id) {
        for (Product product : productList) {
            if (product.getIdSanPham() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> finByName(String name) {
        List<Product> listSearch = new ArrayList<>();
        for (Product product: productList){
            if(product.getTenSanPham().toLowerCase().contains(name.toLowerCase())){
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
