package com.glasscat.generics;


record Pair<T,U>(T first, U second) { }

public class TestTupleRecord {
    public Pair<String, Integer> get() {
        return new Pair<>("success", 200);
    }
}
