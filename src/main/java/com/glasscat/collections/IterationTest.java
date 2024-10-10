package com.glasscat.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class CustomIterator<T> implements Iterator<T> {
    private final Iterator<T> iterator;

    CustomIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public T next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public void remove() {
        iterator.remove();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}

public class IterationTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("S", "y", "ggg", "lwh"));
        CustomIterator<String> i = new CustomIterator<>(list.iterator());
        while (i.hasNext()) {
            String y = i.next();
            System.out.println(y);
        }
    }
}
