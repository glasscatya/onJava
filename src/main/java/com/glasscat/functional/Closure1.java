package com.glasscat.functional;

import java.util.function.IntSupplier;

public class Closure1 {
    IntSupplier makeFun(final int x) {
        int i = 700;

        return () -> x + i;
    }
}
