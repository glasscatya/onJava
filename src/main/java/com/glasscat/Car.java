package com.glasscat;

public class Car {
    int x = 0;
    private String color;
    Car() {
        System.out.println("Car被构造了");
    }
    public Car(String color) {
        this.color = color;
    }

    private void printAllColor() {
        System.out.println("All color: ");
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected String getColor() {
        printAllColor();
        return color;
    }
}
