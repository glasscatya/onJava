package com.glasscat.concurrent;

import java.util.stream.IntStream;

public class CountingStream {
    public static void main(String[] args) throws Exception {
        System.out.println(
                IntStream.range(0, 10)
                        .parallel()
                        .mapToObj(CountingTask::new)
                        .map(ct -> {
                            try {
                                return ct.call();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .reduce(0, Integer::sum)
        );
    }
}
