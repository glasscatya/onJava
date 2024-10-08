package com.glasscat.generics;

import java.lang.reflect.InvocationTargetException;

public class ClassTypeCapture<T> {
    private Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object o) {
        return kind.isInstance(o);
    }

    public T get() {
        try {
            return kind.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture<String> sc = new ClassTypeCapture<>(String.class);
        System.out.println(sc.f("xiao"));
    }
}
