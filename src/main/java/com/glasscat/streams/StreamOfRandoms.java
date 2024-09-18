package com.glasscat.streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOfRandoms {
    static Random random = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4)
                .flatMapToInt(i ->
                        IntStream.concat(
                                random.ints(0, 100).limit(i), IntStream.of(-1)
                        )).forEach(i -> System.out.format("%d ", i));
    }
}
