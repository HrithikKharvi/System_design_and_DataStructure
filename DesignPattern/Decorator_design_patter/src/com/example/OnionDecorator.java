package com.example;

public class OnionDecorator extends BasePizza{

    private int price;
    private BasePizza basePizza;

    public OnionDecorator(BasePizza base){
        this.basePizza = base;
        this.price = 10;
    }

    public int getPrice(){
        return this.price + basePizza.getPrice();
    }

}
