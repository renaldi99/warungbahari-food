package com.example.warungbahari.controller;

import com.example.warungbahari.constant.ApiUrlConstant;
import com.example.warungbahari.entity.Purchase;
import com.example.warungbahari.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiUrlConstant.PURCHASE)
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    public Purchase savePurchase(@RequestBody Purchase purchase) {
        System.out.println("masuk" + purchase.getId());
        return purchaseService.savePurchase(purchase);
    }
}
