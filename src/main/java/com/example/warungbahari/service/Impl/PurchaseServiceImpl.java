package com.example.warungbahari.service.Impl;

import com.example.warungbahari.entity.Product;
import com.example.warungbahari.entity.Purchase;
import com.example.warungbahari.entity.PurchaseDetails;
import com.example.warungbahari.repository.PurchaseRepository;
import com.example.warungbahari.service.ProductService;
import com.example.warungbahari.service.PurchaseDetailsService;
import com.example.warungbahari.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ProductService productService;

    @Autowired
    PurchaseDetailsService purchaseDetailsService;

    @Override
    public Purchase savePurchase(Purchase purchase) {
        Purchase purchase1 = purchaseRepository.save(purchase);
        purchase1.setDateOfPurchase(new Date());

        for (PurchaseDetails p : purchase.getPurchaseDetails()) {
            p.setPurchase(purchase1);
            Product product = productService.getProductById(p.getProduct().getId());
            double amount = p.getQuantity() * product.getPriceProduct();
            p.setAmountTotal(amount);
            purchaseDetailsService.savePurchaseDetail(p);
        }

        return purchase1;
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return null;
    }
}
