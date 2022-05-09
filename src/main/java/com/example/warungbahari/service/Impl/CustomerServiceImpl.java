package com.example.warungbahari.service.Impl;

import com.example.warungbahari.constant.MessageException;
import com.example.warungbahari.entity.Customer;
import com.example.warungbahari.exception.DataNotFoundException;
import com.example.warungbahari.repository.CustomerRepository;
import com.example.warungbahari.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(String customerId) {
        if (customerRepository.findById(customerId).isPresent()) {
            return customerRepository.findById(customerId).get();
        } else {
            String message = String.format(MessageException.DATA_NOT_FOUND, "Customer", customerId);
            throw new DataNotFoundException(message);
        }
    }

    @Override
    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer customer1 = customerRepository.findById(customer.getId()).get();
        customer.setStatus(customer1.getStatus());
        customer.setDateVerification(customer1.getDateVerification());
        customer.setIsVerified(customer1.getIsVerified());
        customer.setPassword(customer1.getPassword());
        customerRepository.save(customer);
    }
}
