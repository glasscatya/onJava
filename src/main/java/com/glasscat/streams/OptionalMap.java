package com.glasscat.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalMap {
    static String[] elements = {"12", "", "23", "24"};
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, String> func) {
        System.out.println(desc + "------------");
        for(int i = 0; i <= elements.length; i++) {
            testStream().skip(i)
                    .findFirst()
                    .map(func);
        }
    }
}
