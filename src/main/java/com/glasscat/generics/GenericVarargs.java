package com.glasscat.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
    @SafeVarargs
    public static <T> List<T> makeList(T...ars) {
        List<T> list = new ArrayList<>();
        for(T t : ars) {
            list.add(t);
        }
        return list;
    }
}
