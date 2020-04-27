package com.cakeshop.accessingdatajpa;

import com.cakeshop.entities.Cake;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class CakeRepositoryTest {

    @Autowired
    CakeRepository cakeRepository;

    @Test
    public void saveCake() {
        Cake cake = new Cake("Cupcake");
        cakeRepository.save(cake);
        Assert.notNull(cakeRepository.findByCakeName("Cupcake"));
    }
}
