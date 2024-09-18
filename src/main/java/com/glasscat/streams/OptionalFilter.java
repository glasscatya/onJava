package com.glasscat.streams;

import java.util.Arrays;
import java.util.function.Predicate;

public class OptionalFilter {
    static String[] testString = {"111", "222", "#33", "A232", "", "s"};

    //Predicate的泛型用于规定其test方法的接收参数的类型
    static void test(String desc, Predicate<String> predicate) {
        System.out.println("===" + desc + "===");
        for (int i = 0; i <= testString.length; i++)
            System.out.println(
                    Arrays.stream(testString)
                            .skip(i)
                            .findFirst()
                            .filter(predicate)
            );
    }

    public static void main(String[] args) {
        test("true", str -> true);
    }
}
