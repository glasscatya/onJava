package com.glasscat.streams;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Pair {
    public final Character c;
    public final int i;
    Pair(Character c, int i) {
        this.c = c;
        this.i = i;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "c=" + c +
                ", i=" + i +
                '}';
    }

    public int getI() {
        return i;
    }

    public Character getC() {
        return c;
    }
}

class RandomPair {
    Random random = new Random(47);

    Iterator<Character> capChar = random.ints(65, 91)
                                        .mapToObj(i -> (char) i)
                                        .iterator();
    public Stream<Pair> stream() {
        return random.ints(100, 1000)
                .distinct()
                .mapToObj(i -> new Pair(capChar.next(), i));
    }
}


public class MapCollector {
    public static void main(String[] args) {
        var map = new RandomPair().stream().limit(10)
                                          .collect(Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
