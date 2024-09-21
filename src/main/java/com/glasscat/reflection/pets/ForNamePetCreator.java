package com.glasscat.reflection.pets;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
//
//public class ForNamePetCreator extends Creator {
//    private static List<Class<? extends Pet>> types = new ArrayList<>();
//
//    private static List<String> typeNames = List.of(
//            "com.glasscat.reflection.pets.Mutt",
//            "com.glasscat.reflection.pets.Pug",
//            "com.glasscat.reflection.pets.EgyptianMau",
//            "com.glasscat.reflection.pets.Manx",
//            "com.glasscat.reflection.pets.Cymric",
//            "com.glasscat.reflection.pets.Rat",
//            "com.glasscat.reflection.pets.Mouse",
//            "com.glasscat.reflection.pets.Hamster"
//    );
//
//    private static void loader() {
//        for(String name : typeNames) {
//            try {
//                types.add((Class<? extends Pet>) Class.forName(name));
//            }  catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    static {
//        loader();
//    }
//
//    @Override
//    public List<Class<? extends Pet>> types() {
//        return types;
//    }
//}
