package com.example.warungbahari.service;

import com.example.warungbahari.entity.Purchase;

import java.util.List;

public interface PurchaseService {
    public Purchase savePurchase(Purchase purchase);
    public List<Purchase> getAllPurchase();
}
