package com.example.gaztnik2_0.service;

import com.example.gaztnik2_0.model.Product;
import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    void sellProduct(int productId, int quantity);
    void updateProduct(Product product);
    List<Product> getAllProducts();
}
