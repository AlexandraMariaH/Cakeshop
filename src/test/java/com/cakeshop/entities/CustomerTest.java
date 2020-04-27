package com.cakeshop.entities;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void testGetter_getsFirstname() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Customer customer = new Customer();
        final Field field = customer.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(customer, "Lena");

        //when
        final String result = customer.getFirstName();

        //then
        assertThat(result).isEqualTo("Lena");
    }

    @Test
    public void testGetter_getsLastName() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Customer customer = new Customer();
        final Field field = customer.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(customer, "Bauer");

        //when
        final String result = customer.getLastName();

        //then
        assertThat(result).isEqualTo("Bauer");
    }
}
