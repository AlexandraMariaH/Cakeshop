package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer("Tom","Müller");
        customerRepository.save(customer);
        Assert.notNull(customerRepository.findByLastName("Müller"));
    }
}