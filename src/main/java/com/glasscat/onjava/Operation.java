package com.glasscat.onjava;

public interface Operation {
    private void hi() {
        System.out.println("hi");
    }

    void execute();
    static void runOps(Operation... operations) {
        for (Operation op : operations) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}
