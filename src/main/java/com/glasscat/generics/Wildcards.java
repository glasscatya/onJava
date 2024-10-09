package com.glasscat.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Wildcards {
    static void rawArgs(Holder holder, Object arg) {
        //相当于未声明泛型
        holder.set(arg);
        //所以放啥都可以 因为Holder的参数要求是T 未声明的情况下，被擦除成为Object
        //holder.set("hi");
        //丢失了类型信息。
        Object object = holder.get();
        System.out.println(object);
    }

    static void unboundedArg(Holder<?> holder, Object arg) {
        //<?>声明意味着只能实例化 和 读取获得Object对象 无法往里面写入 因为编译器要求类型为“?” 没有对象满足"?"
        //holder = arg;
        //holder.set("hi");
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        //任何试图给holder写数据的行为都会报错
        //holder.set(arg); 报错 因为holder中实际存放的类型是T及其子类，没人知道具体是什么
        //只能set为null，或者重新赋值 只有这两种方法能改变set
        holder = null;
        holder.set(null);
        //读的时候很简单，因为读出的数据一定是T及其子类。
        return holder.get();
    }

    //<? super T>是消费者 只写入
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        //可以任意写入符合<? super T>的数据
        holder.set(arg);
        //只能用Object读，因为读出来的数据是T或T的任意父类 丢失类型信息
        Object obj = holder.get();
    }


    static <T> T getItem(List<? extends T> list, Supplier<T> supplier) {
        return list.isEmpty() ? supplier.get() : list.getFirst();
    }

    static <T> T commonGetItem(List<T> list, Supplier<? super T> supplier) {
        return list.isEmpty() ? (T) supplier.get() : list.getFirst();
    }


    public static void main(String[] args) {
        List<Long> list = Arrays.asList(1L, 2L);
        //List<Number> list = Arrays.asList(1L, 2L);
        Supplier<Object> supplier = () -> 42;
        getItem(list, supplier);
        supplier = () -> "sss";
        commonGetItem(list, supplier);




        Holder raw = new Holder<>();
        raw = new Holder();

        Holder<Long> qualified = new Holder<>(); //明确为Long
        Holder<?> unbounded = new Holder<>(); //?为任意某个类型 只有Object能存他读出来的内容
        Holder<? extends Long> bounded = new Holder<>();//可以读Long及其父类
        Long lng = 1L;
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        //
        unboundedArg(raw, lng);
        //exact1的测试
        Object r1 = exact1(raw); // raw没有声明泛型 编译器会将其认定为Object
        Long r2 = exact1(qualified); //
        Object r3 = exact1(unbounded);//unbounded 的泛型声明为<?> 读出来的数据只能被编译器推断为Object
        Long r4 = exact1(bounded); //bounded 的泛型声明为<? extends Long> 读出来的数据 编译器推断为Long

        //exact2的测试
        Long r5 = exact2(raw, lng); // 警告，因为raw没有声明泛型,但因为exact2有第二个参数，二参会被用于推断T类型
        String r5String = exact2(raw, "类型推断"); //就像这样 二参会被用于推断类型

        Long r6 = exact2(qualified, lng); // qualified明确为Long类型
        //Long r6 = exact2(qualified, "lng");  这样就会报错 因为编译器无法推断用户想要的是Long还是String;
        //Long r7 = exact2(unbounded, lng);  报错，因为第一个类型为？，二参为Long 编译器无法推断.

        //Long r8 = exact2(bounded, lng); // <?> <T> <? extends T> <? super T>他们四个互不兼容
    }

}
