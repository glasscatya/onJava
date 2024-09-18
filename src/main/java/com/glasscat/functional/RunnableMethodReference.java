package com.glasscat.functional;

class Go {
    static void go() {
        System.out.println("Go:go");
    }

}

public class RunnableMethodReference {
    public static void main(String[] args) {
        //匿名内部类 实现 run()
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("anonymous");
            }
        }).start();
        //lambda实现 run()
        new Thread(() -> System.out.println("lambda")).start();

        //
        new Thread(Go::go).start();

    }


}
