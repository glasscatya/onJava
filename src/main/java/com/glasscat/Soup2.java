package com.glasscat;

class Soup2 {
    private Soup2() {}

    private static Soup2 ps1 = new Soup2(); // [2]

    public static Soup2 access() {
        System.out.println("Soup2 access");
        ps1.f();
        return ps1;
    }

    public void f() {
        System.out.println("Soup2.f()");
    }
}
