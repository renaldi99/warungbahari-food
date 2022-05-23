package com.example.warungbahari.service.Impl;

import com.example.warungbahari.entity.PurchaseDetails;
import com.example.warungbahari.repository.PurchaseDetailsRepository;
import com.example.warungbahari.service.PurchaseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseDetailsImpl implements PurchaseDetailsService {
    @Autowired
    PurchaseDetailsRepository purchaseDetailsRepository;

    @Override
    public PurchaseDetails savePurchaseDetail(PurchaseDetails purchaseDetails) {
        return purchaseDetailsRepository.save(purchaseDetails);
    }
}
