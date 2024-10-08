package com.glasscat.generics;

import com.glasscat.onjava.Suppliers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class IntegerFactory implements Supplier<Integer> {
    private int i = 0;

    @Override
    public Integer get() {
        return ++i;
    }
}

class Widget {
    private int id;
    Widget(int n) {
        id = n;
    }

    @Override
    public String toString() {
        return "Widget: " + id;
    }
    //静态内部类工厂 也就是类由自身提供，而不是在泛型中实例化。
    public static class Factory implements Supplier<Widget> {
        private int i;
        @Override
        public Widget get() {
            return new Widget(++i);
        }
    }
}

class Fudge {
    private static int count = 1;
    private int n = count++;

    @Override
    public String toString() {
        return "Fudge: " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();

    Foo2(Supplier<T> gen) {
        Suppliers.fill(x, gen, 5);
    }

    @Override
    public String toString() {
        return x.toString();
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2<>(new IntegerFactory()));

        System.out.println(new Foo2<>(new Widget.Factory()));

        System.out.println(new Foo2<>(Fudge::new));
    }
}
