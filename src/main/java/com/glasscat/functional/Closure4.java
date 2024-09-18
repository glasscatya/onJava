package com.glasscat.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure4 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure4 c4 = new Closure4();
        List<Integer> l1 = c4.makeFun().get(), l2 = c4.makeFun().get();
        l1.add(888);
        l2.add(999);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(c4.makeFun().get());
    }
}
