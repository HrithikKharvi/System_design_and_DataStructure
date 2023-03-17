package com.example;

public class Main {

    public static void main(String[] args) {
        BasePizza basePizza = new BasePizza();

        CheeseDecorator cheeseDecorator = new CheeseDecorator(basePizza);
        OnionDecorator onionDecorator = new OnionDecorator(cheeseDecorator);
        CheeseDecorator extraCheese = new CheeseDecorator(onionDecorator);

        System.out.println("Total Price of the pizza : " + extraCheese.getPrice());
    }
}
