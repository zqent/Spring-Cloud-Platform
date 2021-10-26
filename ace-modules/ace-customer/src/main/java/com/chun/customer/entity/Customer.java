package com.chun.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

/*
* 客户模型
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customerId;
    @Column(name="saa_id")
    private Long saaId;
    @Column(name="customer_type")
    private String customerType;
    @Column(name="source")
    private String source;
    @Column(name="user_type")
    private int userType;
    @Column(name="user_id")
    private Long userId;
    @Column(name="effective_date")
    private Date effectiveDate;
    @Column(name="expiry_date")
    private Date expiryDate;

}
