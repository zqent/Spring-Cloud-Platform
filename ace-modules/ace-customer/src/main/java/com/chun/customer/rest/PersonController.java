package com.chun.customer.rest;

import com.chun.customer.entity.Person;
import com.chun.customer.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/api/customer/person",produces = "application/json")
@CrossOrigin(origins="*")
@RefreshScope
public class PersonController {

    private  PersonRepository personRepository;
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    @PostMapping(path = "/add")
    public void addNewPerson(@RequestBody Person person) {
            personRepository.save(person);
    }

    @GetMapping(path = "/info")
    public Optional<Person> findOne(@RequestParam Long id) {
        return personRepository.findById(id);
    }
    @GetMapping(path = "/info2")
    public Person findPerson(@RequestParam Long id) {
        return personRepository.findByPersonId(id);
    }

    @GetMapping(path = "/page")
    public Page<Person> findMany(@RequestParam String key, Integer pageNumber, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "personId");
        PageRequest page = PageRequest.of(pageNumber - 1, pageSize,sort);
        String fmtKey = "%"+key.trim()+"%";
        return personRepository.findByAliasContainsOrLastNameContainsOrFirstNameContainsOrEmailOrIdNumberContainsOrCellPhoneContainsOrLiveAddrContains(fmtKey,
                fmtKey, fmtKey, fmtKey, fmtKey, fmtKey, fmtKey, page);
    }
}