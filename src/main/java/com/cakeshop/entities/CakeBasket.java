package com.cakeshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CakeBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int qtyInStock;
    private String cakeName;

    @OneToOne(mappedBy = "cakeBasket")
    private Customer customer;

    @OneToMany(mappedBy = "cakeBasket")
    private List<Cake> cakes;

    public CakeBasket() {
    }

    public CakeBasket(int qtyInStock, String cakeName) {
        super();
        this.qtyInStock = qtyInStock;
        this.cakeName = cakeName;
    }

}
