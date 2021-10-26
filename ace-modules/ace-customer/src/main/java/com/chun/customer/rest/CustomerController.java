package com.chun.customer.rest;

import com.chun.customer.entity.Customer;
import com.chun.customer.service.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/customer/customer",produces = "application/json")
@CrossOrigin(origins="*")
@RefreshScope
public class CustomerController {
    private  CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @GetMapping(path = "/add")
    public void addNewCustomer(String customerType, String source, Long userId, Integer userType) {
        Customer c = new Customer();
        c.setCustomerType(customerType);
        c.setSource(source);
        c.setUserId(userId);
        c.setUserType(userType);
        customerRepository.save(c);
    }

    @GetMapping(path = "/info")
    public Optional<Customer> findOne(@RequestParam Long id) {
        return customerRepository.findById(id);
    }
}
