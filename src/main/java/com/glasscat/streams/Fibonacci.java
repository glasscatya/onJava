package com.glasscat.streams;

import java.util.stream.*;

public class Fibonacci {
    private int x = 1;
    Stream<Integer> numbs () {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.numbs().skip(20).limit(10).forEach(System.out::println);
    }
}
