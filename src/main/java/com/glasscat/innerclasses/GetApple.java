package com.glasscat.innerclasses;

class Apple {
    public static long counter;
    public final long id = counter++;

    public long id() {
        return id;
    }
}

public class GetApple {
    public static void main(String[] args) {
        new Apple();
        new Apple();
        Apple a = new Apple();

        System.out.println(a.id());
    }
}


