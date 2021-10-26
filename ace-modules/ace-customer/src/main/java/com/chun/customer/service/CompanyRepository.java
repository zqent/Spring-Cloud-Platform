package com.chun.customer.service;

import com.chun.customer.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface CompanyRepository extends PagingAndSortingRepository<Company,Long> {
    List<Company> findByCompanyName(String companyName);
    Company findByCompanyId(Long companyId);
    Page<Company> findByCompanyNameContainsOrTaxNumberContainsOrRegisterAddrContainsOrOfficeAddrContains(String companyName,String taxNumber,String registerAddr,String officeAddr, Pageable page);
}
