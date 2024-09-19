package com.glasscat.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        var ts = Files.lines(Path.of("src/main/java/com/glasscat/streams/TreeSetOfWords.java"))
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .filter(s -> !s.matches("\\d+")) //过滤掉数字
                .map(String::trim)
                .filter(s -> s.length() > 2)    //过滤掉太短的
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(ts);
    }
}
