package com.chun.customer.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.Date;

/*
* 员工模型
* */

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;
    @Column(name="orientation_date")
    private Date orientationDate;
    @Column(name="leave_date")
    private Date leaveDate;
    @Column(name="person_id")
    private Long personId;
    @Column(name="company_id")
    private Long companyId;
    @Column(name="dept_id")
    private Long deptId;
    @Column(name="title")
    private String title;
    @Column(name="post_id")
    private Long postId;

    //以下为关联字段，不应射到当前表
    @Transient
    private String lastName;
    @Transient
    private String firstName;
    @Transient
    private String cellPhone;
    @Transient
    private String idNumber;
    @Transient
    private String computerNumber;
    @Transient
    private String email;
    @Transient
    private String liveAddr;
    @Transient
    private String alias;
    @Transient
    private String deptName;
    @Transient
    private String postName;


}
