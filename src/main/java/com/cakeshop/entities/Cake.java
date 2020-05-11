package com.cakeshop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cakeName;
    private double price;
    private int qtyInStock;
    private String url;

    @ManyToOne
    @JoinColumn(name="cakeBasket_id")
    private CakeBasket cakeBasket;

    public Cake() {
    }

    public Cake(String cakeName) {
        this.cakeName = cakeName;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format("Cake[id=%d, cakeName='%s', price='%f', qtyInStock=%d]",
                id, cakeName, price, qtyInStock);
    }
}
