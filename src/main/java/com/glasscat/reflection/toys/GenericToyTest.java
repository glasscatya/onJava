package com.glasscat.reflection.toys;

import java.lang.reflect.InvocationTargetException;

public class GenericToyTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<FancyToy> fct = FancyToy.class;
        FancyToy fancyToy = fct.getConstructor().newInstance();

        Class<? super FancyToy> sft = fct.getSuperclass();
        //Class<Toy> ct = fct.getSuperclass();  返回的是Class<? super FancyToy>
    }
}
