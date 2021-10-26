package com.chun.customer.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/*
* 人员模型
* */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {
    @Column(name="person_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @Column(name="last_name")
    private String lastName;
    @Column(name="first_name")
    private String firstName;
    @Column(name="cell_phone")
    private String cellPhone;
    @Column(name="id_number")
    private String idNumber;
    @Column(name="computer_number")
    private String computerNumber;
    @Column(name="email")
    private String email;
    @Column(name="live_addr")
    private String liveAddr;
    @Column(name="alias")
    private String alias;

}

