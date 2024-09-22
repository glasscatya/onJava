package com.glasscat.generics;

import java.util.Iterator;

public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;

    public IterableFibonacci(int count) {
        n = count;
    }
    //适配器 拓展了Fibonacci类的适用范围。
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                //匿名内部类使用外部类的this
                return IterableFibonacci.this.get();
            }
        };
    }

    public static void main(String[] args) {
        for(Integer i : new IterableFibonacci(18)) {
            System.out.println(i);
        }
    }
}
