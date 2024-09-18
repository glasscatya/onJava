package com.glasscat.streams;

import static java.util.stream.IntStream.range;

public class Ranges {
    public static void main(String[] args) {
        //System.out.println(range(10, 20).sum());
        //repeat(100, () -> System.out.println("Looping"));
        int n = 10;
    }

    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());
    }
}
