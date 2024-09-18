package com.glasscat.corejava.pair3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestGen {
    static void printBuddies(Pair<? extends Employee> pair) {
        Employee first = pair.getFirst();
        Employee second = pair.getSecond();
        System.out.println(first.getName() + ":" + second.getName());
    }
    public static void main(String[] args) {
        ArrayList<Employee> a = new ArrayList<>();
        Predicate<Object> oddH = o -> o.hashCode() % 2 != 0;
        a.removeIf(oddH);

    }
}
