package com.glasscat.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionMap {
    String[] testString = {"99", "", "69", "10099"};
    Stream<String> toStream() {
        return Arrays.stream(testString);
    }

    public static void testMap(String desc, Function<String, String> fun) {
        System.out.println("Function : " + desc);
        new FunctionMap().toStream()
                .map(fun)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        testMap("0 -> 999", s -> s.replace("0", "999"));
        testMap("+1", s -> {
            try {
                return Integer.parseInt(s) + 1  + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });

        testMap("print [String]", s -> "[" + s + "]");
    }
}
