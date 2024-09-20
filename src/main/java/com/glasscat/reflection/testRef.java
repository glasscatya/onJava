package com.glasscat.reflection;

class testR {
    static {
        System.out.println("loader testR");
    }
}

public class testRef {
    public static void main(String[] args) {
        Class c = testR.class;
        try {
            Class c1 = Class.forName("com.glasscat.reflection.testR");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
