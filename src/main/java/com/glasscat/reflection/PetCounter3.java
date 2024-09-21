package com.glasscat.reflection;

import com.glasscat.reflection.pets.Pet;
import com.glasscat.onjava.Pair;
import com.glasscat.reflection.pets.PetCreator;

import java.util.HashMap;
import java.util.stream.Collectors;

public class PetCounter3 {
    static class Counter extends HashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(PetCreator.ALL_TYPES
                    .stream()
                    .map(type -> Pair.make(type, 0))
                    .collect(Collectors.toMap(Pair::key, Pair::value)));
        }

        public void count(Pet pet) {
            entrySet().stream()
                      .filter(pair -> pair.getKey().isInstance(pet))
                      .forEach(pair -> put(pair.getKey(), pair.getValue() + 1));
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Pet Count:\n");
            entrySet().forEach(entry ->
                    sb.append(entry.getKey().getSimpleName())
                      .append(": ")
                      .append(entry.getValue())
                      .append("\n")
            );
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        new PetCreator().streams()
                        .limit(2000)
                        .peek(counter::count)
                        .forEach(System.out::println);
        System.out.println(counter);
    }
}
