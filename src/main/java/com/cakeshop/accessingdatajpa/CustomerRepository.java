package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByFirstName(String firstName);

    Customer findByLastName(String lastName);
    List<Customer> findAll();
}
