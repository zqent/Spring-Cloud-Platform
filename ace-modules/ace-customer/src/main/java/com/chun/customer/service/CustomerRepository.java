package com.chun.customer.service;

import com.chun.customer.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    List<Customer> findByCustomerId(Long customerId);
}
