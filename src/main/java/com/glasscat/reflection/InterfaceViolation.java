package com.glasscat.reflection;

import com.glasscat.reflection.interfacea.A;

class B implements A {
    @Override
    public void f() {

    }

    public void b() {}
}


public class InterfaceViolation {
    public static void main(String[] args) {
        A a = new B();
        a.f();
        //a.b(); 无法调用

        if (a instanceof B) {
            //强行调用
            ((B) a).b();;
        }
    }
}
