package com.cakeshop.entities;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Cake(String cakeName, double price, int qtyInStock, String url) {
        this.cakeName = cakeName;
        this.price = price;
        this.qtyInStock = qtyInStock;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    @Override
    public String toString() {
        return String.format("Cake[id=%d, cakeName='%s', price='%f', qtyInStock=%d]",
                id, cakeName, price, qtyInStock);
    }
}
