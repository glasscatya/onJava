package com.glasscat.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsOfPaths {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("src/main/java/com/glasscat/files/PathsOfPaths.java").toAbsolutePath();
        for(int i = 0; i < p.getNameCount(); i++) {
            System.out.println(p.getName(i));
        }
        System.out.println("ends with '.java': " + p.endsWith(".java"));
        for(Path pp : p) {
            System.out.print(pp + ".");
        }
        System.out.println(Files.exists(p));
        System.out.println(Files.getOwner(p));

    }
}
