package com.glasscat.functional;

class Dog {
    String name;
    int age = -1;
    Dog() {
        name = "xiaoming";
    }
    Dog(String name) {
        this.name = name;
    }
    Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name : " + name + "age : " +age;
    }
}

interface MakeNoArgs {
    Dog make();
}

interface Make2Arg {
    Dog make(String name, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        Make2Arg m2a = Dog::new;

        System.out.println(mna.make());
        System.out.println(m2a.make("two", 1000));
    }
}
