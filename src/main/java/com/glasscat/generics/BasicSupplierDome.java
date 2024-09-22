package com.glasscat.generics;

import com.glasscat.onjava.BasicSupplier;

import java.util.stream.Stream;

public class BasicSupplierDome {
    public static void main(String[] args) {
        Stream.generate(BasicSupplier.create(CountedObject.class))
                .limit(50)
                .forEach(System.out::println);
    }
}
