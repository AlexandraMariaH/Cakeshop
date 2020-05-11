package com.cakeshop.entities;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;


public class CakeTest {

    @Test
    public void testSetter_setsUrlProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();

        //when
        cake.setUrl("342");

        //then
        final Field field = cake.getClass().getDeclaredField("url");
        field.setAccessible(true);
        assertThat(field.get(cake)).isEqualTo("342");
    }

    @Test
    public void testGetter_getsUrl() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();
        final Field field = cake.getClass().getDeclaredField("url");
        field.setAccessible(true);
        field.set(cake, "342");

        //when
        final String result = cake.getUrl();

        //then
        assertThat(result).isEqualTo("342");
    }

    @Test
    public void testSetter_setsIdProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();

        //when
        cake.setId(1L);

        //then
        final Field field = cake.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertThat(field.get(cake)).isEqualTo(1L);
    }

    @Test
    public void testSetter_setsCakeNameProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();

        //when
        cake.setCakeName("Brownie");

        //then
        final Field field = cake.getClass().getDeclaredField("cakeName");
        field.setAccessible(true);
        assertThat(field.get(cake)).isEqualTo("Brownie");
    }

    @Test
    public void testGetter_getsCakeName() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();
        final Field field = cake.getClass().getDeclaredField("cakeName");
        field.setAccessible(true);
        field.set(cake, "Brownie");

        //when
        final String result = cake.getCakeName();

        //then
        assertThat(result).isEqualTo("Brownie");
    }

    @Test
    public void testSetter_setsPriceProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();

        //when
        cake.setPrice(2.50);

        //then
        final Field field = cake.getClass().getDeclaredField("price");
        field.setAccessible(true);
        assertThat(field.get(cake)).isEqualTo(2.50);
    }

    @Test
    public void testGetter_getsPrice() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();
        final Field field = cake.getClass().getDeclaredField("price");
        field.setAccessible(true);
        field.set(cake, 2.50);

        //when
        final double result = cake.getPrice();

        //then
        assertThat(2.50).isEqualTo(2.50);
    }

    @Test
    public void testSetter_setsQtyInStockProperly() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();

        //when
        cake.setQtyInStock(4);

        //then
        final Field field = cake.getClass().getDeclaredField("qtyInStock");
        field.setAccessible(true);
        assertThat(field.get(cake)).isEqualTo(4);
    }

    @Test
    public void testGetter_getsQtyInStock() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Cake cake = new Cake();
        final Field field = cake.getClass().getDeclaredField("qtyInStock");
        field.setAccessible(true);
        field.set(cake, 4);

        //when
        final int result = cake.getQtyInStock();

        //then
        assertThat(result).isEqualTo(4);
    }

}
