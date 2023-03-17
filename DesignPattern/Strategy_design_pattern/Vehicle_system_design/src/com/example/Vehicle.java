package com.example;

public class Vehicle {

    private Accelerate accelerate;
    private int speed = 0;

    public Vehicle(Accelerate accelerate){
        this.accelerate = accelerate;
    }

    public void accelerate(){
        this.speed = this.accelerate.increaseSpeed(this.speed);
        System.out.println(this.speed);
    }

}
