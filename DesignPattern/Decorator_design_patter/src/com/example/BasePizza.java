package com.example;

public class BasePizza implements Pizza{
    private int price;
    public BasePizza(){
        this.price = 50;
    }

    public int getPrice(){
        return this.price;
    }

}
