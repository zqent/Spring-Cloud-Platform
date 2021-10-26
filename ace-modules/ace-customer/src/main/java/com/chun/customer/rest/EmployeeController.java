package com.chun.customer.rest;

import com.chun.customer.entity.Employee;
import com.chun.customer.entity.Person;
import com.chun.customer.service.EmployeeRepository;
import com.chun.customer.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/customer/employee",produces = "application/json")
@CrossOrigin(origins="*")
@RefreshScope
public class EmployeeController {
    private  EmployeeRepository employeeRepository;
    private   PersonRepository personRepository;
    public EmployeeController(EmployeeRepository employeeRepository,PersonRepository personRepository){
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
    }
    @GetMapping(path = "/add")
    public void addNewEmployeeWithPerson(Long personId,Long companyId, Long deptId, Long postId,String title) {
        Employee e = new Employee();
        e.setCompanyId(companyId);
        e.setDeptId(deptId);
        e.setPersonId(personId);
        e.setPostId(postId);
        e.setTitle(title);
        employeeRepository.save(e);
    }
    @GetMapping(path = "/new")
    public void addNewEmployee(Long companyId, Long deptId,  Long personId,Long postId,String title,String firstName,String lastName, String idNumber, String cellPhone, String computerNumber, String liveAddr, String email, String alias) {

        Person x = personRepository.findByFirstNameAndLastNameAndIdNumber(firstName, lastName,idNumber);
        if(x==null){
            Employee e = new Employee();
            e.setCompanyId(companyId);
            e.setDeptId(deptId);
            e.setPersonId(x.getPersonId());
            e.setPostId(postId);
            e.setTitle(title);
            employeeRepository.save(e);
            x = personRepository.findByFirstNameAndLastNameAndIdNumber(firstName, lastName,idNumber);
        }
        if(x!=null){
            Person p = new Person();
            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setAlias(alias);
            p.setCellPhone(cellPhone);
            p.setIdNumber(idNumber);
            p.setComputerNumber(computerNumber);
            p.setLiveAddr(liveAddr);
            p.setEmail(email);
            p.setPersonId(x.getPersonId());
            personRepository.save(p);
        }

    }

    @GetMapping(path = "/info")
    public Optional<Employee> findOne(@RequestParam Long id) {
        return employeeRepository.findById(id);
    }
}
