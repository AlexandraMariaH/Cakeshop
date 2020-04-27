package com.cakeshop.entities;

import lombok.Data;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
