package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.Customer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void saveCustomer() {
        Customer customer = new Customer("Tom","Müller");
        customerRepository.save(customer);
        Assert.assertNotNull(customerRepository.findByLastName("Müller"));
    }
}