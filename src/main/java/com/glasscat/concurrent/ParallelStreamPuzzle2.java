package com.glasscat.concurrent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamPuzzle2 {
    private static final Deque<String> trace = new ConcurrentLinkedDeque<>();

    static class IntGenerator implements Supplier<Integer> {
        private AtomicInteger current = new AtomicInteger();

        @Override
        public Integer get() {
            trace.add(current.get() + ": " + Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) throws IOException {
        List<Integer> list = Stream.generate(new IntGenerator())
                                   .limit(10)
                                   .parallel()
                                   .toList();
        Files.write(Paths.get("PSP2.txt"), trace);
        System.out.println(list);
        //.collect(Collectors.toList());
    }
}
