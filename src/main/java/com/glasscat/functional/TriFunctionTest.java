package com.glasscat.functional;


interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TriFunctionTest {
    static int f(int i, double d, float f) {
        return (int)(i + d +f);
    }

    public static void main(String[] args) {
        TriFunction<Integer, Double, Float, Integer> t = TriFunctionTest::f;
        System.out.println(t.apply(100, 2000.0, 2000F));
        t = (i, d, f) -> (int)(i+d+f)*200;
        System.out.println(t.apply(100, 2000.0, 2000F));
    }
}
