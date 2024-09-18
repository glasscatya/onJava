package com.glasscat.functional;

import java.util.function.IntSupplier;
//{error javac}
public class Closure3 {
    IntSupplier makeFun(final int x) {
        Integer i = 0;
        //i = i + 1;
        return () -> x + i;
    }
}
