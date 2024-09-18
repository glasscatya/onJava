package com.glasscat.Collections;

public class CompactConstructor {
    public static void main(String[] args) {
        //try {
        //    new Point(100, -1);
        //} catch (IllegalArgumentException e) {
        //    System.out.println("异常:" + e.getLocalizedMessage());
        //}
        new Point(100, -1);
    }
}


record Point(int x, int y) {
    void asserPositive(int val) {
        if(val < 0) throw new IllegalArgumentException("negative");
    }

    Point {
        asserPositive(x);
        asserPositive(y);
    }
}