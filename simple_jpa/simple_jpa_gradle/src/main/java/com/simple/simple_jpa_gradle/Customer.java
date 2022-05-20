package com.simple.simple_jpa_gradle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    protected Customer(){};

    public Customer(String fisrtName, String lastName){
        this.firstName = fisrtName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format(
            "Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName
            );
    }

    public Long getId(){
        return id;
    }

    public String getFirstname(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
}
