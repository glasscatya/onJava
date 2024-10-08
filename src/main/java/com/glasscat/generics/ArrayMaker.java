package com.glasscat.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        //虽然显示声明了T的类型，但是因为类型擦除
        //实际上 Array.newInstance 并不知道kind的类型，所以要用强制类型转换。
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] strings = stringMaker.create(9);
        System.out.println(Arrays.toString(strings));
    }
}
