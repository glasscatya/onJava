package com.glasscat.streams;

import java.util.Random;
import java.util.stream.Stream;

class Frobnitz {
    int size;

    Frobnitz(int sz) {
        size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz{" + "size=" + size + '}';
    }

    static Random rand = new Random();
    static final int BOUND = 1000;

    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
              .limit(10)
              .peek(System.out::println)
              .reduce((f0, f1) -> f0.size < 50 ? f0 : f1)
              .ifPresent(System.out::println);
    }
}
