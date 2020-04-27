package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CustomerRepository;
import com.cakeshop.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerControllerService {

    @Autowired
    private CustomerRepository customerRepository;



    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    public Iterable<Customer> getAllRegisteredCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(String firstName) {
        Customer customerToDelete = customerRepository.findByFirstName(firstName);
        customerRepository.delete(customerToDelete);
    }

    public Customer updateCustomerInformation(String firstName, String newEmail) {
        Customer customerFromDb = customerRepository.findByFirstName(firstName);
        customerFromDb.setEmailAdress(newEmail);
        Customer updatedCustomer = customerRepository.save(customerFromDb);
        return updatedCustomer;
    }
}
