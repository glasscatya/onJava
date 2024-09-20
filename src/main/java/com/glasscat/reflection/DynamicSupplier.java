package com.glasscat.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ID {
    private static long count;
    private final long id = count++;

    @Override
    public String toString() {
        return "ID{" +
                "id=" + id +
                '}';
    }

    public ID() {
    }
}


public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> t;
    DynamicSupplier (Class<T> t) {
            this.t = t;
    }

    @Override
    public T get() {
        try {
            return t.getConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Stream.generate(new DynamicSupplier<>(ID.class))
              .skip(10)
              .limit(5)
              .forEach(System.out::println);
    }
}
