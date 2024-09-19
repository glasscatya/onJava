package com.glasscat.streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

public class Matching {
    static void show(Matcher match, int val) {
        System.out.println(
                //BiPredicate的boolean test(T t, U u);方法。
                match.test(
                        IntStream.rangeClosed(1, 9)
                                .boxed()
                                .peek(System.out::println),
                        n -> n < val
                )
        );
    }

    public static void main(String[] args) {
        //通过方法引用，allMatch相当于实现了test。
        //方法引用 可以理解为 一个实例调用一个方法 用于实现需要实现的方法。
        Matching.show(Stream::allMatch, 5);
        //Lambda表达式
        Matching.show((s,p) -> s.allMatch(p), 10);
        //Predicate是测试器  而intS 是流实例。
        Matching.show(new Matcher() {
            @Override
            public boolean test(Stream<Integer> integerStream, Predicate<Integer> integerPredicate) {
                return integerStream.allMatch(integerPredicate);
            }
        }, 10);
    }
}
