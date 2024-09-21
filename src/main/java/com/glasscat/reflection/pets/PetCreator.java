package com.glasscat.reflection.pets;

import com.glasscat.reflection.PetCounter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PetCreator extends Creator {
    public static final List<Class<? extends Pet>> ALL_TYPES =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class,
                    Manx.class, Cymric.class, Rat.class,
                    Mouse.class, Hamster.class
            ));

    public static List<Class<? extends Pet>> TYPES =
            ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class), ALL_TYPES.size());


    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        //System.out.println(TYPES);
        //List<Pet> pets = new PetCreator().list(7);
        new PetCounter().count(new PetCreator());
        //System.out.println(pets);
    }
}
