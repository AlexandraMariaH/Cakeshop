package com.cakeshop.restservice;

import com.cakeshop.entities.CakeBasket;
import com.cakeshop.entities.Customer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

        //Simplifying Link Creation with the RepresentationModelAssembler
        // This simple interface has one method: toModel().
        // It is based on converting a non-resource object (Customer)
        // into a resource-based object (EntityModel<Customer>).
        @Override
        public EntityModel<Customer> toModel(Customer customer) {

            // Unconditional links to single-item resource and aggregate root

            EntityModel<Customer> customerModel = new EntityModel<>(customer,
                    linkTo(methodOn(CustomerController.class).getCustomerByFirstName(customer.getFirstName())).withSelfRel(),
                    linkTo(methodOn(CustomerController.class).getAllRegisteredCustomers()).withRel("customer")
            );

            // Conditional links based on state of the customer


//                customerModel.add(
//                        linkTo(methodOn(CustomerController.class)
//                                .cancel(customer.getFirstName())).withRel("cancel"));
//                customerModel.add(
//                        linkTo(methodOn(CustomerController.class)
//                                .complete(customer.getFirstName())).withRel("complete"));

            return customerModel;
        }
}
