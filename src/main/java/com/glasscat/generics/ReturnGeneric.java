package com.glasscat.generics;

public class ReturnGeneric<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        ReturnGeneric<String> rgs = new ReturnGeneric<>();
        rgs.set("hi");
        String s = rgs.get();
    }
}
