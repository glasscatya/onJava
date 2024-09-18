package com.glasscat.testFan;

import com.glasscat.onjava.Vehicle;

public class Bike extends Vehicle {
    private int speed = 1000;

    private Bike() {
        run();
        System.out.println(this);
    }
    @Override
    public void run() {
        System.out.println("Bike is running" + speed);
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Bike();
    }
}
