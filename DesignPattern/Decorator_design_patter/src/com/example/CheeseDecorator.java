package com.example;

public class CheeseDecorator extends BasePizza{

    private int price;
    private BasePizza basePizza;

    public CheeseDecorator(BasePizza child){
        this.basePizza = child;
        this.price = 20;
    }

    public int getPrice(){
        return this.price + basePizza.getPrice();
    }

}
