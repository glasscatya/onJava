package com.glasscat.Collections;

import com.glasscat.reflection.pets.Pet;
import com.glasscat.reflection.pets.PetCreator;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Pet> {
    private Pet[] pets = new PetCreator().array(8);

    @Override
    public Iterator<Pet> iterator() {

        return new Iterator<Pet>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    @Override
    public int size() {
        return pets.length;
    }

    public static void main(String[] args) {
        CollectionSequence cs = new CollectionSequence();
        InterfaceVsIterator.display(cs);
        InterfaceVsIterator.display(cs.iterator());
    }
}
