package com.glasscat.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddAndSubtractPaths {
    //当前目录往上走三级
    static Path base = Paths.get("..", "..", "..").toAbsolutePath().normalize();
    static Path curr = Paths.get(".").toAbsolutePath().normalize();

    static void show(int id, Path result) {
        if (result.isAbsolute()) {
            System.out.println("(" + id + ")r " + base.relativize(result));
        } else {
            System.out.println("(" + id + ") " + result);
        }

        try {
            System.out.println("RealPath: " + result.toRealPath());
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        System.out.println(base);
        System.out.println(curr);

        Path p = Paths.get("src/main/java/com/glasscat/files/AddAndSubtractPaths.java")
                      .toAbsolutePath();
        show(1, p);

        Path convoluted = p.getParent().getParent()
                .resolve("strings")
                .resolve("..")
                //p.getParent().getFileName() 获得父目录的名字
                .resolve(p.getParent().getFileName());
        show(2, convoluted);

        show(3, convoluted.normalize());

        Path p2 = Paths.get("..", "..");
        show(4, p2);
        show(5, p2.normalize());
        show(6, p2.toAbsolutePath().normalize());
        show(100, p2.toAbsolutePath().normalize());

        Path p3 = Paths.get(".").toAbsolutePath();
        show(7, p3);
    }
}
