package com.glasscat.innerclasses;


abstract class Base {
    Base(int i) {
        System.out.println("Base constructor,i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {
    public static int x;
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
                System.out.println("wo!");
            }
            @Override
            public void f() {
                System.out.println("Anonymous f()");
                System.out.println("x = " + x);
            }
        };
    }

    public static void main(String[] args) {
        Base b = AnonymousConstructor.getBase(1000);
        AnonymousConstructor.x = 1000;
        b.f();
        AnonymousConstructor.x = 20000;
        b.f();
    }
}
