/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author girija
 */
@Controller
@EnableJpaRepositories
public class DemoController {

    @Autowired
    private EmployeeRepository repository;

    @RequestMapping("/findAll")
    @ResponseBody
    public String helloHandlerfind() {
        Page<Employee> x = repository.findAll(new PageRequest(1, 4));
        return x.getContent().toString();
    }

    @RequestMapping("/findFirstName")
    @ResponseBody
    public String findFirstName(@RequestParam(value = "name") String s) {
        List<Employee> x = repository.findByFirstName(s);
        return x.toString();
    }

    @RequestMapping("/findId")
    @ResponseBody
    public String findId(@RequestParam(value = "id") Long s) {
        List<Employee> x = repository.findById(s);
        return x.toString();
    }

    @Transactional
    @RequestMapping("/deleteId")
    @ResponseBody
    public String deleteId(@RequestParam(value = "id") Long s) {
        List<Employee> x = repository.findById(s);
        repository.delete(x);
        return x.toString();
    }

    @Transactional
    @RequestMapping("/removeLastName")
    @ResponseBody
    public String removeByLastName(@RequestParam(value = "name") String s) {
        Long x = repository.removeByLastName(s);
        return x.toString();
    }

    @Transactional
    @RequestMapping("/deleteByLastName")
    @ResponseBody
    public String deleteByLastname(@RequestParam(value = "name") String s) {
        List<Employee> x = repository.deleteByLastName(s);
        return x.toString();
    }

    @RequestMapping("/findLastName")
    @ResponseBody
    public String findLastName(@RequestParam(value = "name") String s) {
        List<Employee> x = repository.findByLastName(s);
        return x.toString();
    }

    @RequestMapping("/")
    @ResponseBody
    public String helloHandler() {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            Employee emp = new Employee();
            emp.setId(100l + i);
            emp.setAge(i + 10);
            emp.setFirstName("FirstName" + i);
            emp.setLastName("LastName" + i);
            employeeList.add(emp);
        }
        repository.save(employeeList);

        return "<h1>Hello World!</h1>";
    }

}
