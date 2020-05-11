package com.cakeshop.restservice;

import com.cakeshop.AccessingDataJpaApplication;
import com.cakeshop.accessingdatajpa.CustomerRepository;
import com.cakeshop.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AccessingDataJpaApplication.class)
public class CustomerControllerHttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CustomerRepository customerRepository;

//    @Test
//    public void customerShouldReturnCustomerInformation() throws Exception {
//
//        Customer customer = new Customer("Paolo","Spaht");
//        customer.setEmailAdress("Paolo.Spaht@gmail.com");
//        customerRepository.save(customer);
//
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/allCustomers", String.class)).contains("{\"_embedded\":{\"customerList\":[{\"id\":1,\"firstName\":\"Paolo\",\"lastName\":\"Spaht\",\"emailAdress\":\"Paolo.Spaht@gmail.com\",\"_links\":{\"self\":{\"href\":\"http://localhost:" + port + "/Paolo\"},\"customer\":{\"href\":\"http://localhost:" + port +"/allCustomers\"}}}]},\"_links\":{\"self\":{\"href\":\"http://localhost:" + port +"/allCustomers\"}}}");
//    }
}
