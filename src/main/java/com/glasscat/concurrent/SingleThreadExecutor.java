package com.glasscat.concurrent;

import com.glasscat.onjava.Nap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        //提交后立刻就会执行.
        IntStream.range(0, 10)
                .mapToObj(NapTask::new)
                .forEach(exec::submit);
        System.out.println("All tasks submitted.");
        exec.shutdown();
        //主线线程中执行
        while (!exec.isTerminated()) {
            System.out.println(Thread.currentThread().getName() + " awaiting");
            new Nap(0.1);
        }
    }
}
