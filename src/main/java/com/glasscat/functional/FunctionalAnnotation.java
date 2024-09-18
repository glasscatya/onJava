package com.glasscat.functional;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

public class FunctionalAnnotation {
    String goodbye(String arg) {
        return "goodbye," + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();

        Functional f = fa::goodbye;
        System.out.println(f.goodbye("xiaoming"));
        f = a -> "Goodbye!!!" + a;
        System.out.println(f.goodbye("s"));
    }
}
