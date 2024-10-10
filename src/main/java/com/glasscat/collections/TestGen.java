package com.glasscat.collections;

class Parent<T> {
    public T getValue(T t) {
        return t;
    }
}

class Child extends Parent<String> {
    @Override
    public String getValue(String t) {
        return t;
    }
}

public class TestGen {
    public static void main(String[] args) {
        Parent c = new Child();
        System.out.println(c.getValue("1"));
    }
}