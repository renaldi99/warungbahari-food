package com.example.warungbahari.controller;

import com.example.warungbahari.constant.ApiUrlConstant;
import com.example.warungbahari.entity.Customer;
import com.example.warungbahari.service.CustomerService;
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
@RequestMapping(ApiUrlConstant.CUSTOMER)
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public PageResponseWrapper<Customer> getAllCustomer(@RequestParam(name = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(name = "limit", defaultValue = "5") Integer limit,
                                                        @RequestParam(name = "sortBy", defaultValue = "name") String sortBy,
                                                        @RequestParam(name = "direct", defaultValue = "asc") String direct) {
        Sort sort = Sort.by(Sort.Direction.fromString(direct), sortBy);
        Pageable pageable = PageRequest.of(page, limit, sort);
        Page<Customer> page1 = customerService.getAllCustomer(pageable);
        return new PageResponseWrapper<>(page1);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
        String message = String.format("Customer is updated");
        return ResponseEntity.ok(new ResponseOnceMessage(message));
    }

    @DeleteMapping
    public ResponseEntity deleteCustomer(@RequestParam String customerId) {
        customerService.deleteCustomerById(customerId);
        String message = String.format("Customer is deleted");
        return ResponseEntity.ok(new ResponseOnceMessage(message));
    }
}
