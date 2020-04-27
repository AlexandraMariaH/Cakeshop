package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CakeRepository;
import com.cakeshop.entities.Cake;
import com.cakeshop.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CakeControllerService {

    @Autowired
    private CakeRepository cakeRepository;

    public Cake createCake(Cake cake) {
        return cakeRepository.save(cake);
    }

    public Cake getCakebyName(String name) {
        return cakeRepository.findByCakeName(name);
    }

    public Iterable<Cake> getAllCakes() {
        return cakeRepository.findAll();
    }

    public void deleteCake(String name) {
        Cake cakeToDelete = cakeRepository.findByCakeName(name);
        cakeRepository.delete(cakeToDelete);
    }

    public Cake updateCakeInformation(String name, String newCakeName) {
        Cake cakeFromDb = cakeRepository.findByCakeName(name);
        cakeFromDb.setCakeName(newCakeName);
        Cake updatedCake = cakeRepository.save(cakeFromDb);
        return updatedCake;
    }
}
