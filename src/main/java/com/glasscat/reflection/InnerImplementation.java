package com.glasscat.reflection;

import com.glasscat.reflection.interfacea.A;

import java.lang.reflect.InvocationTargetException;

class InnerA {
    private static class C implements A {
        @Override
        public void f() {
            System.out.println("Inner.private.C.f()");
        }

        public void g() {
            System.out.println("C.g()");
        }

        private void p() {
            System.out.println("C.p");
        }
    }

    public static A makeA() {
        return new C();
    }
}

public class InnerImplementation {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = InnerA.makeA();
        a.f();
        //不存在C
        //if(a instanceof C)

        //使用反射仍然可以调用
        HiddenImplementation.callHiddenMethod(a, "p");

    }
}
