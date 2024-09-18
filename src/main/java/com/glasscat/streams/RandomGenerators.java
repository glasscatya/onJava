package com.glasscat.streams;

import java.util.Random;
import java.util.stream.Stream;

public class RandomGenerators {
    public static <T> void show(Stream<T> stream) {
        stream
                .limit(4)
                .forEach(System.out::println);
        System.out.println("+++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random();
        show(rand.ints().boxed());
        show(rand.ints(100,200000).boxed());

    }
}
