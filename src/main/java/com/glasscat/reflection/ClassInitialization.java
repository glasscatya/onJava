package com.glasscat.reflection;


import java.util.Random;

class Initable {
    //编译时常量：编译时就已经可以确定的量。
    static final int STATIC_FINAL = 42;
    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initable初始化");
    }
}

class Initable2 {
    static int staticNonFinal = 42;
    static {
        System.out.println("Init2初始化");
    }
}


class Initable3 {
    static int staticNonFinal = 42;
    static {
        System.out.println("Init3初始化");
    }
}

public class ClassInitialization {
    static Random rand = new Random(42);

    public static void main(String[] args) {
        //使用类字面量获取类不会导致初始化
        Class init = Initable.class;
        System.out.println("init初始化之前");
        //这一步不会导致Initable初始化，因为读取的是"编译时常量"
        System.out.println(Initable.STATIC_FINAL);
        //这一步会导致Initable初始化，因为读取的是"运行时常量"，需要初始化后获取
        System.out.println(Initable.STATIC_FINAL2);
        System.out.println("init初始化之后");
        //静态字段读取也会导致初始化。
        System.out.println(Initable2.staticNonFinal);

        //使用forName获取类会导致类被加载 ， 注意被加载与初始化不一样
        try {
            Class init3 = Class.forName("com.glasscat.reflection.Initable3");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}












