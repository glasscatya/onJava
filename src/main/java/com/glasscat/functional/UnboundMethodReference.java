package com.glasscat.functional;

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}


public class UnboundMethodReference {
    public static void main(String[] args) {
        //MakeString ms = X::f;
        TransformX tf = X::f;
        X x = new X();
        System.out.println(tf.transform(x));
        System.out.println(x.f());
    }
}
