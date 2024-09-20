package com.glasscat.reflection;

class Base {
    //测试初始化，静态<字段和代码块> 会在初始化中被执行。
    static {
        System.out.println("1");
    }
    //测试实例初始化，字段和代码块先实例化，然后调用构造器
    {
        System.out.println("2");
    }

    public Base() {
        System.out.println("Base init---3");
    }
}

class Derived extends Base {
    //初始化，会在父类初始化后进行初始化。
    static {
        System.out.println("4");
    }
    //实例化 会在父类实例化后实例化
    {
        System.out.println("5");
    }
    //会先进入构造器，但是会进入super，然后在继续执行构造器
    public Derived() {
        //这里会被隐式的调用super
        System.out.println("6");
    }

}

public class TestInit {
    public static void main(String[] args) {
        //先测试初始化 使用forName 可以实现仅初始化
        try {
            Class.forName("com.glasscat.reflection.Derived");
            //预测结构 1 -> 4
            // 证明初始化确实是先父类初始化 后子类初始化
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //再测试实例化过程
        var d = new Derived();
        //预测 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //😂结果是 1->4->2->3->5->6
        //也就是说 正确的顺序是
        // 1.当子类被实例化时，会先进行初始化。初始化从父类进行，再到子类。
        // 2.初始化完成后，再开始实例化，还是从父类开始，再到子类。
        // 也就是这两步 先递归初始化，再递归实例化(实例初始化和构造器调用)。
    }
}
