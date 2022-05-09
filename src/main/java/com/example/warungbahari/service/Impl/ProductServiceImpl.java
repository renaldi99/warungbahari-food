package com.example.warungbahari.service.Impl;

import com.example.warungbahari.constant.MessageException;
import com.example.warungbahari.entity.Product;
import com.example.warungbahari.exception.DataNotFoundException;
import com.example.warungbahari.repository.ProductRepository;
import com.example.warungbahari.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> getAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getProductById(String productId) {
        if (productRepository.findById(productId).isPresent()) {
            return productRepository.findById(productId).get();
        } else {
            String message = String.format(MessageException.DATA_NOT_FOUND, "Product", productId);
            throw new DataNotFoundException(message);
        }
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
