package com.example.themleaf_product_management.service;

import com.example.themleaf_product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void insertProduct(Product product);
    public void update(Product product,int id);
    void deleteProduct(int id);
    Product seeDetails(int id);
    List<Product> finByName(String name);
}
