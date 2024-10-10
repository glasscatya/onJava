package com.glasscat.concurrent;

import java.util.Arrays;

public class Summing2 {
    static long basicSum(long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }


    public static final int SZ = 11_000_000;
    public static final long CHECK =
            (long) SZ * ((long) SZ + 1) / 2; // Gauss's formula

    public static void main(String[] args) {
        System.out.println(CHECK);

        long[] la = new long[SZ + 1];
        Arrays.parallelSetAll(la, i -> i);

        Summing.timeTest("Array Sum,", CHECK, () -> Arrays.stream(la).sum());
        Summing.timeTest("Parallel", CHECK, () -> Arrays.stream(la).parallel().sum());
        Summing.timeTest("basic:", CHECK, () -> basicSum(la));

        Summing.timeTest("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });

    }
}
