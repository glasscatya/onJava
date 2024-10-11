package com.glasscat.concurrent;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CachedThreadPool3 {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        List<CountingTask> tasks = IntStream.range(0, 10)
                                            .mapToObj(CountingTask::new)
                                            .toList();
        //先去执行Futures 也就是这里会发生阻塞 返回后再回到主线程
        List<Future<Integer>> futures = exec.invokeAll(tasks);
        System.out.println("任务完成");
        Integer sum = futures.stream()
                             .map(CachedThreadPool3::extractResult)
                             .reduce(0, Integer::sum);
        System.out.println("sum: " + sum);

        exec.shutdown();
    }
}
