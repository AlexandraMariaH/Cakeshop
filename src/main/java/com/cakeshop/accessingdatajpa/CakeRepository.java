package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.Cake;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CakeRepository extends CrudRepository<Cake, Long> {

    Cake findByCakeName(String cakeName);
}
