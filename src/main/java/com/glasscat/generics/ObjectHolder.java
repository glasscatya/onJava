package com.glasscat.generics;

import com.glasscat.reflection.pets.Pet;

public class ObjectHolder {
    private Object objectHolder;

    public ObjectHolder(Object objectHolder) {
        this.objectHolder = objectHolder;
    }

    public void setObjectHolder(Object objectHolder) {
        this.objectHolder = objectHolder;
    }

    public Object getObjectHolder() {
        return objectHolder;
    }

    public static void main(String[] args) {
        var oh = new ObjectHolder(new Pet());
        Pet pet = (Pet) oh.getObjectHolder();
        System.out.println(pet.id());
        oh.setObjectHolder("sss");
        String s = (String) oh.getObjectHolder();
        System.out.println(s);
    }
}
