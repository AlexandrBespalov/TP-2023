package com.example.gaztnik2_0.dao;

import com.example.gaztnik2_0.model.Product;

import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    Product getProductById(int productId);
    List<Product> getAllProducts();
}
