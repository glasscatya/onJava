package com.glasscat.functional;

class This {
    void two(int a, int b) {
        System.out.println(a + ":" + b);
    }

    void three(int a, int b, int c) {
    }

    void four(int a, int b, int c, int d) {
    }
}

interface TwoArgs {
    void call2(This athis, int a, int b);
}


public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoA = This::two;
        This athis = new This();
        //将类的普通方法通过lambda表达式传入时，接口中需要持有对该类的this，以用来调用实例方法。
        twoA.call2(athis, 1, 2);
    }
}

