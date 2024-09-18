package com.glasscat.innerclasses;

public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        @Override
        public void howdy() {
            System.out.println("我是实现了在接口中实现了接口的内部类");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }


}
