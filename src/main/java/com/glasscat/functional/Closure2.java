package com.glasscat.functional;

import java.util.function.IntSupplier;

public class Closure2 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        int Fi = i;
        int Fx = x;
        return () -> Fi + Fx;
    }
}
