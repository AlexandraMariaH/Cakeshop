package com.cakeshop;

import com.cakeshop.entities.Cake;
import com.cakeshop.entities.Customer;
import com.cakeshop.restservice.CakeControllerService;
import com.cakeshop.restservice.CustomerControllerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccessingDataJpaApplication {

    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationcontext = SpringApplication.run(AccessingDataJpaApplication.class, args);

        CustomerControllerService customerControllerService = applicationcontext.getBean("customerControllerService", CustomerControllerService.class);
        Customer customer = new Customer();
        customer.setFirstName("Paula");
        customer.setLastName("Schmidt");

        customerControllerService.createCustomer(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jens");
        customer2.setLastName("Krupp");

        customerControllerService.createCustomer(customer2);

        customerControllerService.deleteCustomer("Paula");

        customerControllerService.updateCustomerInformation("Jens", "Jens.Krupp@gmail.com");


        CakeControllerService cakeControllerService = applicationcontext.getBean("cakeControllerService", CakeControllerService.class);
        Cake cake = new Cake();
        cake.setCakeName("Blondie");
        cake.setQtyInStock(10);
        cake.setPrice(3.00);

        cakeControllerService.createCake(cake);

        Cake cake2 = new Cake();
        cake2.setCakeName("Biscuitrolle");
        cake2.setQtyInStock(3);
        cake2.setPrice(4.00);

        cakeControllerService.createCake(cake2);

        cakeControllerService.deleteCake("Biscuitrolle");

        cakeControllerService.updateCakeInformation("Blondie", "RawBlondie");
    }

//    @Bean
//    public CommandLineRunner demoCustomer(CustomerRepository repository) {
//        return (args) -> {
//            // save a few customers
//            repository.save(new Customer("Max", "Müller"));
//            repository.save(new Customer("Lisa", "Bauer"));
//
//            // fetch all customers
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Customer customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");
//
//            // fetch an individual customer by ID
//            Customer customer = repository.findById(1L);
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//
//            // fetch customers by last name
//            log.info("Customer found with findByLastName('Bauer'):");
//            log.info("--------------------------------------------");
//            repository.findByLastName("Bauer").forEach(bauer -> {
//                log.info(bauer.toString());
//            });
//            log.info("");
//        };
//    }
//
//    @Bean
//    public CommandLineRunner demoCake(CakeRepository repository) {
//        return (args) -> {
//            // save a few cakes
//            repository.save(new Cake("Brownie", 3.50, 2, "342"));
//            repository.save(new Cake("Strawberry-Cheesecake", 4.50, 7, "455"));
//
//            // fetch all cakes
//            log.info("Cakes found with findAll():");
//            log.info("-------------------------------");
//            for (Cake cake : repository.findAll()) {
//                log.info(cake.toString());
//            }
//            log.info("");
//
//            // fetch an individual cake by ID
//            Cake cake = repository.findById(3L);
//            log.info("Cake found with findById(3L):");
//            log.info("--------------------------------");
//            log.info(cake.toString());
//            log.info("");
//
//            // fetch cake by cakeName
//            log.info("Cake found with findByCakeName('Brownie'):");
//            log.info("--------------------------------------------");
//            repository.findByCakeName("Brownie").forEach(Brownie -> {
//                log.info(Brownie.toString());
//            });
//            log.info("");
//        };
//    }
}