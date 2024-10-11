package com.glasscat.concurrent;

import com.glasscat.onjava.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService es = Executors.newCachedThreadPool();
        //toList是一个终结操作 会导致流真正开始计算 也就是这150个线程
        List<QuittableTask> tasks = IntStream.range(0, COUNT)
                                            .mapToObj(QuittableTask::new)
                                            .peek(qt -> es.execute(qt))
                                            .toList();
        new Nap(1);

        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}
