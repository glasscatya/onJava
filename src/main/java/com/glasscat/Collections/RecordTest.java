package com.glasscat.Collections;

public class RecordTest {
    record Nested(String s) {}
    String method() {
        record Local(String s) {}
        var l = new Local("方法内部类");
        return l.s();
    }

    public static void main(String[] args) {

        System.out.println(new Nested("sss").s());
        var rt = new RecordTest();
        System.out.println(rt.method());
    }
}
