package com.cakeshop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String emailAdress;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', emailAdress='&s']",
                id, firstName, lastName, emailAdress);
    }

}