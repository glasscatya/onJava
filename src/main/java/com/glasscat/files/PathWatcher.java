package com.glasscat.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class PathWatcher {
    static Path test = Paths.get("test");

    //删除test目录下的txt文件
    static void delTxtFiles() {
        try {
            Files.walk(test)
                 .filter(f -> f.toString().endsWith(".txt"))
                 .forEach(f -> {
                     try {
                         System.out.println("正在删除: " + f);
                         Files.delete(f);
                     } catch (IOException e) {
                         throw new RuntimeException(e);
                     }
                 });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        //刷新test目录
        Directories.refreshTestDir();
        //生成四个 xxx/xxx/xxx目录
        Directories.populateTestDir();

        Files.createFile(test.resolve("Hello.txt"));

        WatchService ws = FileSystems.getDefault().newWatchService();
        //给Path test注册一个监听器，触发条件为test内实体被删除时。
        test.register(ws, ENTRY_DELETE);

        Executors.newSingleThreadScheduledExecutor()
                .schedule(PathWatcher::delTxtFiles,
                        250,
                        TimeUnit.MILLISECONDS);
        while(true) {
            WatchKey key = ws.take();
            for (WatchEvent evt : key.pollEvents()) {
                System.out.println(
                        "evt.context " + evt.context() +
                                "\nevt.count() " + evt.count() +
                                "\nevt.kind() " + evt.kind()
                );
            }
        }

    }
}
