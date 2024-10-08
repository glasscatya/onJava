package com.glasscat.files;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamInAndOut {
    public static void main(String[] args) throws IOException {
        try (
                Stream<String> input = Files.lines(
                        Paths.get("src/main/java/com/glasscat/files/StreamInAndOut.java"));
                PrintWriter output = new PrintWriter("StreamInAndOut.txt")
        ) {
            input.map(String::toUpperCase)
                 .forEachOrdered(output::println);
        }


    }
}
