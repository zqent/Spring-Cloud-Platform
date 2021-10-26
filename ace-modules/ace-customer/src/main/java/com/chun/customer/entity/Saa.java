package com.chun.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/*
 *
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Saa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;
    @Column(name="CompanyId")
    private Long companyid;
    @Column(name="state")
    private Integer state;
    @Column(name="locked")
    private Integer locked;

}
