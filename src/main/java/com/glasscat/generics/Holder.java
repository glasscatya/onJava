package com.glasscat.generics;

import java.util.Objects;

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //实际上编译器并不在意<? extends Fruit>内部是否真的被读取，他只负责检查参数类型和返回值类型。
        return obj instanceof Holder && Objects.equals(value, ((Holder)obj).value);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);
        //装苹果的盒子 不能放入 装水果的盒子
        //Holder<Fruit> fruitHolder = appleHolder;

        Holder<? extends Fruit> fruit = new Holder<>(new Apple()); //<? extends Fruit>可以初始化成所有Fruit及其子类。
        Fruit p = fruit.get();
        d = (Apple) fruit.get();
        Orange c = (Orange) fruit.get();//运行时错误 Apple不能强转成Orange

    }
}
