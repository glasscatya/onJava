package com.glasscat.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RandInts {
    public static int[] ints =
            new Random(42)
                    .ints(0, 1000)
                    .limit(100)
                    .toArray();

    public static IntStream rands() {
        return Arrays.stream(ints);
    }
}
