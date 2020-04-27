package com.cakeshop.restservice;

import com.cakeshop.entities.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/cake/")
public class CakeController {

    @Autowired
    private CakeControllerService cakeControllerService;

    @PostMapping(value = "/createCake")
    public Cake createCake(@RequestBody Cake cake) {
        return cakeControllerService.createCake(cake);
    }

    //http://localhost:8081/api/cake/cake/Brownie
    @GetMapping(value = "/cake/{name}")
    public Cake getCakeByName(@PathVariable("name") String name) {
        return cakeControllerService.getCakebyName(name);
    }

    //http://localhost:8081/api/cake/cake/allCakes
    @GetMapping(value = "/cake/allCakes")
    public Iterable<Cake> getAllCakes() {
        return cakeControllerService.getAllCakes();
    }

    @DeleteMapping(value = "/cake/{name}")
    public void deleteCake(@PathVariable("name") String name) {
        cakeControllerService.deleteCake(name);
    }

    @PutMapping(value = "/cake/{name}/{newCakeName:.+}")
    public Cake updateCakeInformation(@PathVariable("name") String name, @PathVariable("newCakeName") String newCakeName) {
        return cakeControllerService.updateCakeInformation(name, newCakeName);
    }
}
