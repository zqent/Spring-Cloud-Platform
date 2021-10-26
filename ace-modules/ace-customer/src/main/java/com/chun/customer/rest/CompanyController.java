package com.chun.customer.rest;

import com.chun.customer.entity.Company;
import com.chun.customer.service.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping(path="/api/customer/company",produces = "application/json")
@CrossOrigin(origins="*")
@RefreshScope
public class CompanyController {
    private  CompanyRepository companyRepository;
    public CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    @GetMapping(path = "/add")
    public void addNewCompany(String companyName, String officeAddr, String registerAddr, String taxNumber) {
        Company c = new Company();
        c.setCompanyName(companyName);
        c.setOfficeAddr(officeAddr);
        c.setRegisterAddr(registerAddr);
        c.setTaxNumber(taxNumber);
        companyRepository.save(c);
    }

    @GetMapping(path = "/info")
    public Optional<Company> findOne(@RequestParam Long id) {
        return companyRepository.findById(id);
    }

    @GetMapping(path = "/page")
    public Page<Company> findOne(@RequestParam String key, Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "personId");
        PageRequest page = PageRequest.of(pageNumber - 1, pageSize,sort);
        return companyRepository.findByCompanyNameContainsOrTaxNumberContainsOrRegisterAddrContainsOrOfficeAddrContains(key,key,key,key,page);
    }
}
