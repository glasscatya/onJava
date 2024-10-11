package com.glasscat.concurrent;

import com.glasscat.onjava.Nap;

import java.util.concurrent.atomic.AtomicBoolean;

public class QuittableTask implements Runnable {
    final int id;

    public QuittableTask(int id) {
        this.id = id;
    }

    private AtomicBoolean running = new AtomicBoolean(true);

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get()) {
            new Nap(0.1);
        }
        System.out.println("id: " + id + "，当前线程是: " + Thread.currentThread().getName());
    }
}
