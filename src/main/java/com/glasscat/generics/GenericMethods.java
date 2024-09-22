package com.glasscat.generics;

public class GenericMethods {
    public <T> void get(T t) {
        System.out.println(t.getClass().getName() + " ");
    }

    public static void main(String[] args) {
        var gm = new GenericMethods();
        gm.get("s");
        gm.get(gm.getClass().getClassLoader().getParent());
        ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
        System.out.println(platformClassLoader);
    }
}
