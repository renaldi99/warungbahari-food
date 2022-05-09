package com.example.warungbahari.controller;

import com.example.warungbahari.constant.ApiUrlConstant;
import com.example.warungbahari.entity.Customer;
import com.example.warungbahari.entity.Product;
import com.example.warungbahari.service.ProductService;
import com.example.warungbahari.utils.PageResponseWrapper;
import com.example.warungbahari.utils.ResponseOnceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.PRODUCT)
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public PageResponseWrapper<Product> getAllProduct(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                      @RequestParam(name = "limit", defaultValue = "5") Integer limit,
                                                      @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
                                                      @RequestParam(name = "direct", defaultValue = "asc") String direct) {
        Sort sort = Sort.by(Sort.Direction.fromString(direct), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        Page<Product> page1 = productService.getAllProduct(pageable);
        return new PageResponseWrapper<>(page1);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        String message = String.format("Product is updated");
        return ResponseEntity.ok(new ResponseOnceMessage(message));
    }

    @DeleteMapping
    public ResponseEntity deleteProductById(@RequestParam String productId) {
        productService.deleteProductById(productId);
        String message = String.format("Product is deleted");
        return ResponseEntity.ok(new ResponseOnceMessage(message));
    }
}
