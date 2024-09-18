package com.glasscat.innerclasses;

public class TestBed {
    public void f() {
        System.out.println("f()");
    }

    public static class Tester {
        public void t() {
            System.out.println("t()");
        }
        public static void main(String[] args) {
            TestBed tb = new TestBed();
            tb.f();
        }
    }

    public static void main(String[] args) {
        new Tester().t();
        Tester.main(args);
    }
}
