package com.example;

public class Main {

    public static void main(String[] args) {
        Accelerate normal = new NormalAccelerate();
        Accelerate medium = new MediumAccelerate();

        Bike bike = new Bike(normal);
        Car car = new Car(medium);
        Bus bus = new Bus(medium);

        bike.accelerate();
        car.accelerate();
        car.accelerate();
        bus.accelerate();

    }
}
