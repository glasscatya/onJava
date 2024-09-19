package com.glasscat.reflection.toys;

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    public Toy() {}

    public Toy(int i) {}
}


class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    static void printInfo(Class cc) {
        //判断 cc是否为interface
        System.out.println("Class name: " + cc.getName() + " is interface ? \n["
                            + cc.isInterface() + "]");

        System.out.println("Simple name: " + cc.getSimpleName());

        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.glasscat.reflection.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            System.exit(1);
        }

        printInfo(c);

        for(Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        printInfo(up);
        Object obj = null;
        try {
            //调用无参构造器
            obj = up.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot instantiate");
        }

        printInfo(obj.getClass());
    }
}














