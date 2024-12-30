package com.SpringTest.SpringTest.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //Getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}
