package com.glasscat.Collections;

import java.util.*;

class ReversibleArrayList<T> extends ArrayList<T> {
    ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> test() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    @Override
                    public void remove() { // Not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}


public class AdapterMethodIdiom {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        Collection<Integer> c = map.values();
        System.out.println(c);
        //ReversibleArrayList<String> ral =
        //        new ReversibleArrayList<>(
        //                Arrays.asList("上海自来水来自海上1".split(""))
        //        );
        //for(String s : ral) {
        //    System.out.print(s);
        //}
        //System.out.println();
        //for(String s : ral.test()) {
        //    System.out.print(s);
        //}
    }
}
