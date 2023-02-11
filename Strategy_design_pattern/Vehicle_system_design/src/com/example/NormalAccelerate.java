package com.example;

public class NormalAccelerate implements Accelerate{
    public int increaseSpeed(int currentSpeed){
        System.out.println("Speed increased by 5");
        return currentSpeed + 5;
    }
}
