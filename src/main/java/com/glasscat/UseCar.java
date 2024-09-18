package com.glasscat;

public class UseCar {
    public static void main(String[] args) {
        Car2 car = new Car2("red");
        car.car3.setColor("hhhh");
        System.out.println(car.getColor());
        car.printColor();
        System.out.println(car.car3.getColor());
    }
}

class Car2 extends Car {
    public final Car car3 = new Car("black");
    public Car2(String color) {
        super(color);
    }
    private void printAllColor() {
        System.out.println("fake All Color");
    }

    public void printColor() {
        printAllColor();
    }
}