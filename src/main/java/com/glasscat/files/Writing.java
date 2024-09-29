package com.glasscat.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random random = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[SIZE];
        //会填满byte[]
        random.nextBytes(bytes);
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.dat size: " + Files.size(Paths.get("bytes.dat")));

        List<String> lines = Files.readAllLines(Paths.get("src/main/java/com/glasscat/streams/ch.dat"));
        Files.write(Paths.get("Cheese.dat"), lines);
        System.out.println("Cheese.dat size: " + Files.size(Paths.get("Cheese.dat")));

    }
}
