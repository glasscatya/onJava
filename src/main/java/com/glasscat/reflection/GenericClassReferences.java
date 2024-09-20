package com.glasscat.reflection;

public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> IntClass = Integer.class;
        IntClass = int.class;
        Class<? extends Number> numbClass = Integer.class;
        //Class<Number> numbClass = int.class; err

        System.out.println(int.class == Integer.TYPE);
    }
}
