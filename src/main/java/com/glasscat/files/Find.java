package com.glasscat.files;

import java.io.File;
import java.nio.file.*;

public class Find {
    public static void main(String[] args) throws Exception {
        Path test = Paths.get("test");
        Directories.refreshTestDir();
        Directories.populateTestDir();

        Files.createDirectory(test.resolve("dir.tmp"));

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(
                "glob:**/*.tmp"
        );
        Files.walk(test)
             .filter(matcher::matches)
             .forEach(System.out::println);
        PathMatcher matcher2 = FileSystems.getDefault().getPathMatcher(
                "glob:*.tmp"
        );
        System.out.println("**********");
        //会混进来一个目录 dir.tmp目录
        Files.walk(test)
             .filter(matcher2::matches)
             .forEach(System.out::println);
        System.out.println("**********");

        Files.walk(test)
             .filter(Files::isRegularFile) //过滤出来文件，格式为 目录/文件名
             .map(Path::getFileName)        // 映射成 文件名
             .filter(matcher2::matches)
             .forEach(System.out::println);
    }
}
