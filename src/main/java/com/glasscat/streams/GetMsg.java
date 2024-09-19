package com.glasscat.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class GetMsg {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10);
        long count = list.stream().count();
        Optional<Integer> max = list.stream().max((a,b) -> a - b);
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
