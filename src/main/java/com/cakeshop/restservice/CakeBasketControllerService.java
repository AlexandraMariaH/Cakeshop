package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CakeBasketRepository;
import com.cakeshop.entities.CakeBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CakeBasketControllerService {

    @Autowired
    private CakeBasketRepository cakeBasketRepository;

    public CakeBasket createCakeBasket(CakeBasket cakeBasket) {
        return cakeBasketRepository.save(cakeBasket);
    }

    public CakeBasket getCakeBasketById(int id) {
       return cakeBasketRepository.findById(id);
    }
}
