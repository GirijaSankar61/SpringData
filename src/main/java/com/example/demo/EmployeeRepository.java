/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author girija
 */
//@Transactional
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findById(Long id);

    Long removeByLastName(String lastname);

    List<Employee> deleteByLastName(String lastname);

    //not implemented
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirstNameAndId(String firstName, String Id);

    List<Employee> findByLastNameIgnoreCase(String lastName);

    List<Employee> findByLastNameOrderByFirstNameAsc(String lastName);

    List<Employee> findByLastNameOrderByFirstNameDesc(String lastname);

    Page<Employee> findByLastName(String lastname, Pageable pageable);

    long countByLastName(String lastname);

    Optional<Employee> findOptionalByFirstName(String firstName);

    //activate distinct
    List<Employee> findDistinctEmployeeByLastName(String lastName);

    //limit applied here
    Employee findFirstByOrderByLastNameAsc();

    Employee findTopByOrderByIdDesc();

    Page<Employee> queryFirst10ByLastName(String lastname, Pageable pageable);

    Slice<Employee> findTop3ByLastName(String lastname, Pageable pageable);

    List<Employee> findFirst10ByLastName(String lastname, Sort sort);

    List<Employee> findTop10ByLastName(String lastname, Pageable pageable);
}
