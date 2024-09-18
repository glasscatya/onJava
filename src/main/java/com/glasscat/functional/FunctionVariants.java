package com.glasscat.functional;

import java.util.function.*;

class Foo {}

class Bar {
    Foo f;
    Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;
    IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    Long l;
    LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;
    DBaz(double d) {
        this.d = d;
    }
}


public class FunctionVariants {
    static Function<Foo, Bar> f1 = Bar::new;
    static IntFunction<IBaz> f2 = IBaz::new;

    public static void main(String[] args) {
        f1.apply(new Foo());
    }
}
