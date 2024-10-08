package com.glasscat.generics;

class Generic<T> {}

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (ClassCastException ce) {
            System.out.println(ce);
        }

        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
        //gia[1] = new Object();
    }
}
