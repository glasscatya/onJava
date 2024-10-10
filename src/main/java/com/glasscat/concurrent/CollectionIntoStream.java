package com.glasscat.concurrent;

import com.glasscat.onjava.Rand;

import java.util.List;
import java.util.stream.Stream;

public class CollectionIntoStream {
    public static void main(String[] args) {
        List<String> strings = Stream.generate(new Rand.String(5))
                                     .limit(10)
                                     .toList();
        strings.forEach(System.out::println);
        //集合转成流 map是中间操作，可以对流进行映射 reduce是终结操作，可以对流进行约化。
        String stringStream = strings.stream().map(String::toUpperCase)
                                     .map(s -> s.substring(2))
                                     .reduce(":", (s1, s2) -> s1 + s2);
        System.out.println(stringStream);

    }
}
