package com.glasscat.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWord {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWord(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1) // Skip the comment line at the beginning
                .forEach(line -> {
                    for(String w : line.split("[ .?,]+"))
                        builder.add(w);
                });
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        //List<String> stringList = new FileToWord("ch.dat").stream().limit(10).map(w -> w + "").collect(Collectors.toList());
        //System.out.println(stringList);
        new FileToWord("F:\\CodePractice\\Java\\Test\\src\\main\\java\\com\\glasscat\\streams\\ch.dat")
                .stream()
                .limit(10)
                .map(w -> w + "")
                .forEach(System.out::println);
    }
}
