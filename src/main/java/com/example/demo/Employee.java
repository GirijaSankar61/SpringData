/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

//import javax.persistence.Column;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 *
 * @author girija
 */
//@Entity
@Document(collection = "Employee")
public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @Column
    private String firstName;
//    @Column
    private String lastName;

//    @Column
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
    }
    
}
