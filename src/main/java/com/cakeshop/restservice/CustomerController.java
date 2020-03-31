package com.cakeshop.restservice;

import com.cakeshop.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/customer/")
public class CustomerController {

    @Autowired
    private CustomerControllerService customerControllerService;

    @PostMapping(value = "/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerControllerService.createCustomer(customer);
    }

    //http://localhost:8081/api/customer/customer/Paula
    @GetMapping(value = "/customer/{firstName}")
    public Customer getCustomerByFirstName(@PathVariable("firstName") String firstName) {
        return customerControllerService.getCustomerByFirstName(firstName);
    }

    //http://localhost:8081/api/customer/customer/allCustomers
    @GetMapping(value = "/customer/allCustomers")
    public Iterable<Customer> getAllRegisteredCustomers() {
        return customerControllerService.getAllRegisteredCustomers();
    }

    @DeleteMapping(value = "/customer/{firstName}")
    public void deleteCustomer(@PathVariable("firstName") String firstName) {
        customerControllerService.deleteCustomer(firstName);
    }

    @PutMapping(value = "/customer/{firstName}/{newEmail:.+}")
    public Customer updateCustomerInformation(@PathVariable("firstName") String firstName, @PathVariable("newEmail") String newEmail) {
        return customerControllerService.updateCustomerInformation(firstName, newEmail);
    }

}
