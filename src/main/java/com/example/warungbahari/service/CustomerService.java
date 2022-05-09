package com.example.warungbahari.service;

import com.example.warungbahari.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    public Customer saveCustomer(Customer customer);
    public Page<Customer> getAllCustomer(Pageable pageable);
    public Customer getCustomerById(String customerId);
    public void deleteCustomerById(String customerId);
    public void updateCustomer(Customer customer);
}
