package com.glasscat.streams;

import java.util.stream.Stream;

public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.<String>empty().findFirst());
    }
}
