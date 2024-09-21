package com.glasscat.reflection.pets;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Creator implements Supplier<Pet> {
    private Random rand = new Random();
    //获取所有类型
    public abstract List<Class<? extends Pet>> types();

    @Override
    public Pet get() {
        int n = rand.nextInt(types().size());

        try {
            //随机获取一个Pet
            return types().get(n)
                          .getConstructor()
                          .newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<Pet> streams() {
        return Stream.generate(this);
    }

    public Pet[] array(int size) {
        return streams().limit(size).toArray(Pet[]::new);
    }

    public List<Pet> list(int size) {
        return streams().limit(size)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

}
