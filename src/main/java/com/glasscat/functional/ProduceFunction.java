package com.glasscat.functional;

import java.util.Locale;
import java.util.function.*;

interface FuncSS extends Function<String, String> {}

public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("Hi"));
        f = new FuncSS() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        System.out.println(f.apply("hi"));

    }
}
