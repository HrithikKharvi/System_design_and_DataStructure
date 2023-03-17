package com.example;

public class MediumAccelerate implements Accelerate{

    public int increaseSpeed(int currentSpeed){
        System.out.println("Speed increased by 10");
        return currentSpeed + 10;
    }

}
