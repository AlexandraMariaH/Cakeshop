package com.cakeshop.restservice;

import com.cakeshop.AccessingDataJpaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AccessingDataJpaApplication.class)
public class CustomerControllerHttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void customerShouldReturnCustomerInformation() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/customer/customer/allCustomers", String.class)).contains("[{\"id\":2,\"firstName\":\"Jens\",\"lastName\":\"Krupp\",\"emailAdress\":\"Jens.Krupp@gmail.com\"}]");
    }
}
