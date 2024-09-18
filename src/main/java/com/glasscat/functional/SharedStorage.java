package com.glasscat.functional;

import java.util.function.IntSupplier;

public class SharedStorage {
    public static void main(String[] args) {
        var c1 = new Closure1();
        IntSupplier is = c1.makeFun(100);
        System.out.println(is.getAsInt());
        System.out.println(is.toString());
    }
}
