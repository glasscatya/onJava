package com.glasscat;

public class newCar extends Car {
    int x = 1;

    newCar() {
        System.out.println("newCar构造");
    }

    public static void main(String[] args) {
        Car car = new newCar();
        newCar newcar = new newCar();

        System.out.println("car.x = " + car.x + ", newcar.x = " + newcar.x);

    }
}
