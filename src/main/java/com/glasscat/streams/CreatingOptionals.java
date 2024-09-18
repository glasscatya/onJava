package com.glasscat.streams;

import java.util.Optional;

public class CreatingOptionals {
    static void test(String testName, Optional<String> opt) {
        System.out.println("===" + testName + "===");
        //orElse 如果存在返回该值，不存在返回参数。
        System.out.println(opt.orElse("null"));
    }

    public static void main(String[] args) {
        test("empty", Optional.empty());

        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }

        test("ofNullable", Optional.ofNullable(null));
    }
}
