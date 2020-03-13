package com.cakeshop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WelcomeControllerTest {

    @Autowired
    private WelcomeController welcomeController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(welcomeController).isNotNull();
    }
}
