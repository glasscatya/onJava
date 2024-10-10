package com.glasscat.concurrent;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ParallelStreamPuzzle {
    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;

        @Override
        public Integer get() {
            return current++;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Stream.generate(new IntGenerator())
                                   .limit(10)
                                   .parallel()
                                   .toList();
        System.out.println(list);
    }
}
