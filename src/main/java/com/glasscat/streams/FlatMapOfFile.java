package com.glasscat.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapOfFile {
    static Stream<String> stream(String filePath) throws IOException {
        return Files.lines(Path.of(filePath))
                .skip(1)
                .flatMap(line -> Pattern.compile("[ .?,]+").splitAsStream(line));
    }

    public static void main(String[] args) throws IOException {
        stream("F:\\CodePractice\\Java\\Test\\src\\main\\java\\com\\glasscat\\streams\\ch.dat")
                .limit(10)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
