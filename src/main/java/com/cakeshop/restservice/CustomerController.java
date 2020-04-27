package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CustomerRepository;
import com.cakeshop.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final CustomerModelAssembler customerModelAssembler;

    CustomerController(CustomerRepository customerRepository, CustomerModelAssembler customerModelAssembler) {
        this.customerRepository = customerRepository;
        this.customerModelAssembler = customerModelAssembler;
    }

    @Autowired
    private CustomerControllerService customerControllerService;

    @PostMapping(value = "/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerControllerService.createCustomer(customer);
    }

    //http://localhost:8081/customer/Paula
    @GetMapping(value = "/customer/{firstName}")
    EntityModel<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName) {

        Customer customer = customerRepository.findByFirstName(firstName);

        return customerModelAssembler.toModel(customer);
    }

    //http://localhost:8081/customer/allCustomers
    @GetMapping(value = "/customer/allCustomers")
    CollectionModel<EntityModel<Customer>> getAllRegisteredCustomers() {

        List<EntityModel<Customer>> customer =
               customerRepository.findAll().stream()
                       .map(customerModelAssembler::toModel)
                       .collect(Collectors.toList());
        return new CollectionModel<>(customer,
                linkTo(methodOn(CustomerController.class).getAllRegisteredCustomers()).withSelfRel());
    }

    @DeleteMapping(value = "/customer/{firstName}")
    ResponseEntity<?> deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/customer/{firstName}/{newEmail:.+}")
    public Customer updateCustomerInformation(@PathVariable("firstName") String firstName, @PathVariable("newEmail") String newEmail) {
        return customerControllerService.updateCustomerInformation(firstName, newEmail);
    }

    public Class<?> cancel(String firstName) {
        return null;
    }

    public Class<?> complete(String firstName) {
        return null;
    }

}
