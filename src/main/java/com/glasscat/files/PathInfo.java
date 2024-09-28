package com.glasscat.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    public static void show(String s, Object p) {
        System.out.println(s + p);
    }

    static void info(Path p) {
        show("toString:\n ", p);
        show("Exists: ", Files.exists(p));
        show("RegularFile: ", Files.isRegularFile(p));
        show("Directory: ", Files.isDirectory(p));
        show("Absolute: ", p.isAbsolute());
        show("FileName: ", p.getFileName());
        show("Parent: ", p.getParent());
        show("Root: ", p.getRoot());
        System.out.println("******************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "NoFile.txt"));

        Path p = Paths.get("src/main/java/com/glasscat/files/PathInfo.java");
        info(p);

        Path ap = p.toAbsolutePath();
        info(ap);

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        URI u = p.toUri();
        System.out.println("URI:\n"+u);

        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();
    }
}
