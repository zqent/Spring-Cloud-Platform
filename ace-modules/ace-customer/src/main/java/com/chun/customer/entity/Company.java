package com.chun.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
* 公司模型
* */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Long companyId;
    @Column(name="company_name")
    private String companyName;
    @Column(name="tax_number")
    private String taxNumber;
    @Column(name="register_addr")
    private String registerAddr;
    @Column(name="office_addr")
    private String officeAddr;

}
