package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.CakeBasket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CakeBasketRepository extends CrudRepository<CakeBasket, Long> {

    CakeBasket findById(int id);
    List<CakeBasket> findAll();

}
