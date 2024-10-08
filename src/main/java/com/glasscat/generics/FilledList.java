package com.glasscat.generics;

import com.glasscat.onjava.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FilledList<T> extends ArrayList<T> {
    FilledList(Supplier<T> gen, int size) {
        Suppliers.fill(this, gen, size);
    }

    public FilledList(T t, int size) {
        for(int i = 0; i < size; i++) {
            this.add(t);
        }
    }


    public static void main(String[] args) {
        List<String> stringList = new FilledList<>("hello", 4);
        System.out.println(stringList);

        List<Integer> integerList = new FilledList<>(() -> 47, 4);
        System.out.println(integerList);
    }
}
