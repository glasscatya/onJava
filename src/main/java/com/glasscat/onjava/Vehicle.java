package com.glasscat.onjava;

public class Vehicle {
    public Vehicle() {
        this.run();
        System.out.println(this);
    }

    protected void run() {
        System.out.println("v is running");
    }
}
