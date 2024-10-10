package com.glasscat.concurrent;

import com.glasscat.onjava.Timer;

import java.util.function.LongSupplier;

public class Summing {
    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.print(id + " ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue)
            System.out.println(timer.duration() + "ms");
        else
            System.out.format("result: %d%ncheckValue: %d%n", result, checkValue);
    }
}
