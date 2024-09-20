package com.glasscat.reflection;

class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> ch = House.class;
        //二者功能一致。
        House h = ch.cast(b);
        h = (House) b;

        System.out.println(h);
    }
}
