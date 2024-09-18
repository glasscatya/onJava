package com.glasscat.streams;

import java.util.stream.Stream;

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("s", "ss", "Sss"))
                .forEach(System.out::println);
    }
}
