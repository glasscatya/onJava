package com.glasscat.streams;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Signal {
    private final String msg;
    public Signal(String msg) {
        this.msg = msg;
    }

    private static Random random = new Random(47);
    public static Signal morse() {
        switch (random.nextInt(4)) {
            case 1: return new Signal("t1");
            case 2: return new Signal("t2");
            default: return null;
        }
    }

    @Override
    public String toString() {
        return "Signal{" +
                "msg='" + msg + '\'' +
                '}';
    }

    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse)
                .map(s -> Optional.ofNullable(s));
    }

    public static void main(String[] args) {
        Signal.stream().limit(10).forEach(System.out::println);
        Signal.stream().skip(100).limit(5)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

    }
}





