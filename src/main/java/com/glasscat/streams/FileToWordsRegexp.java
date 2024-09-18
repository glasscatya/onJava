package com.glasscat.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Paths.get(filePath)).skip(1).collect(Collectors.joining(" "));
    }

    Stream<String> stream() {
        return Pattern.compile("[ .?,]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        var fw = new FileToWordsRegexp("F:\\CodePractice\\Java\\Test\\src\\main\\java\\com\\glasscat\\streams\\ch.dat");

        fw.stream().limit(10).map(w -> w + " ").forEach(System.out::print);
        System.out.println("");
        fw.stream().limit(10).sorted(Comparator.reverseOrder()).map(w -> w + " ").forEach(System.out::print);
    }
}
