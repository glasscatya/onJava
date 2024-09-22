package com.glasscat.generics;

import com.glasscat.reflection.pets.Pet;

public class GenericHolder<T> {
    private T a;

    public GenericHolder() {}

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Pet> gp = new GenericHolder<>();
        gp.set(new Pet());
        //gp.set("111"); 编译器要求一定是pet
    }
}
