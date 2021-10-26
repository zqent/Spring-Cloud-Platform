package com.chun.customer.service;


import com.chun.customer.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    List<Employee> findByEmployeeId(Long employeeId);
}
