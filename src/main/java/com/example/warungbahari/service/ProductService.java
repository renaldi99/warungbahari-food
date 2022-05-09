package com.example.warungbahari.service;

import com.example.warungbahari.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public Page<Product> getAllProduct(Pageable pageable);
    public Product getProductById(String productId);
    public void deleteProductById(String productId);
    public void updateProduct(Product product);
}
