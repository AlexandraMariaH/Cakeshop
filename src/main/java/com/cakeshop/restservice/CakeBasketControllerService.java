package com.cakeshop.restservice;

import com.cakeshop.accessingdatajpa.CakeBasketRepository;
import com.cakeshop.entities.CakeBasket;
import org.springframework.beans.factory.annotation.Autowired;

public class CakeBasketControllerService {

    @Autowired
    private CakeBasketRepository cakeBasketRepository;

    public CakeBasket createCakeBasket(CakeBasket cakeBasket) {
        return cakeBasketRepository.save(cakeBasket);
    }

    //public CakeBasket getCakeBasketById(Long id) {
    //    return cakeBasketRepository.findById(id);
    //}

}
