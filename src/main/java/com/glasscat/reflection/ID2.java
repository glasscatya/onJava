package com.glasscat.reflection;

import java.util.stream.Stream;

public class ID2 {
    private static long count;
    private final long id = count++;

    @Override
    public String toString() {
        return "ID2{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<ID2>(ID2.class))
                .skip(100)
                .limit(200)
                .forEach(System.out::println);
    }
}
