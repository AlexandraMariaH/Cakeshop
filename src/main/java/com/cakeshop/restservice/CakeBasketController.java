package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CakeBasketRepository;
import com.cakeshop.entities.CakeBasket;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CakeBasketController {

    private final CakeBasketRepository cakeBasketRepository;
    private final CakeBasketModelAssembler cakeBasketModelAssembler;

    CakeBasketController(CakeBasketRepository cakeBasketRepository, CakeBasketModelAssembler cakeBasketModelAssembler) {
        this.cakeBasketRepository = cakeBasketRepository;
        this.cakeBasketModelAssembler = cakeBasketModelAssembler;
    }

    @GetMapping("/cakeBaskets")
    CollectionModel<EntityModel<CakeBasket>> all() {
        List<EntityModel<CakeBasket>> cakeBaskets =
                cakeBasketRepository.findAll().stream()
                .map(cakeBasketModelAssembler::toModel)
                .collect(Collectors.toList());

        return new CollectionModel<>(cakeBaskets,
                linkTo(methodOn(CakeBasketController.class).all()).withSelfRel());
    }

    @GetMapping("/cakeBaskets/{id}")
    EntityModel<CakeBasket> one(@PathVariable int id) {
        CakeBasket cakeBasket = cakeBasketRepository.findById(id);

        return cakeBasketModelAssembler.toModel(cakeBasket);
    }

    @PostMapping("/cakeBaskets")
    ResponseEntity<EntityModel<CakeBasket>> newCakeBasket(@RequestBody CakeBasket cakeBasket) {

        CakeBasket newCakeBasket = cakeBasketRepository.save(cakeBasket);

        return ResponseEntity
                .created(linkTo(methodOn(CakeBasketController.class).one(newCakeBasket.getId())).toUri())
                .body(cakeBasketModelAssembler.toModel(newCakeBasket));
    }

    public Class<?> cancel(int id) {
        return null;
    }

    public Class<?> complete(int id) {
        return null;
    }

//    @Autowired
//    private CakeBasketControllerService cakeBasketControllerService;
//
//    @PostMapping(value = "/customer/cakeBasket")
//    public CakeBasket goToCakeBasket(@RequestBody CakeControllerService cakeControllerService, @RequestBody CustomerControllerService customerControllerService) {
//        Iterable<Cake> cakeList = cakeControllerService.getAllCakes();
//        Customer customer = new Customer();
//        CakeBasket cakeBasket = customer.getCakeBasket();
//        return cakeBasket;
//    }


}
