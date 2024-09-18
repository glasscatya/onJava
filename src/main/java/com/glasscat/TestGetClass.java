package com.glasscat;

public class TestGetClass {
    public static void main(String[] args) {
        String str = "hello";
        Class<?> clazz = str.getClass();
        System.out.println(clazz.getName());

        Class<?> myClass = clazz.getClass();
        System.out.println(myClass);
    }

    class MyClass {

    }
}
