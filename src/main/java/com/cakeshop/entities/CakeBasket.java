package com.cakeshop.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CakeBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int qtyInStock;
    private String cakeName;
   // private Cake cake;

    public CakeBasket() {
    }

    public CakeBasket(int qtyInStock, String cakeName) {
        super();
        this.qtyInStock = qtyInStock;
       // this.cake = cake;
        this.cakeName = cakeName;
    }

}
