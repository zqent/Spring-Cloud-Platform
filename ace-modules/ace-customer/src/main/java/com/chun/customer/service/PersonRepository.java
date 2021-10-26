package com.chun.customer.service;

import com.chun.customer.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {
    Page<Person> findByAliasContainsOrLastNameContainsOrFirstNameContainsOrEmailOrIdNumberContainsOrCellPhoneContainsOrLiveAddrContains(
            String alias, String lastName, String firstName, String email, String idNumber, String cellPhone, String liveAddr, Pageable page);

    @Query(value="select * from person where alias like contact('%', :key , '%')  or last_name like contact('%', :key , '%') or first_name like contact('%', :key , '%') or email like contact('%', :key , '%') or id_number like contact('%', :key , '%') or cell_phone like contact('%', :key , '%') or live_addr like contact('%', :key , '%')",nativeQuery=true)
    List<Person> findByKeyLimit(@Param("key") String value);
    Person findByFirstNameAndLastName(String firstName, String lastName);
    Person findByFirstNameAndLastNameAndIdNumber(String firstName, String lastName,String idNumber);
    Person findByPersonId(Long personId);

}
