package com.glasscat.functional;

import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

public class FunctionWithWrapped {
    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double)i;
        IntToDoubleFunction itf = i -> i*2;

    }
}
