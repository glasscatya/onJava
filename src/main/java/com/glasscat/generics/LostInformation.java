package com.glasscat.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Frob {}

class Fnorkle {}

class Quark<Q> {}

class Particle<POSITION, MOMENTUM> {}

public class LostInformation {
    public static void main(String[] args) {
        List<Frob> lf = new ArrayList<>();

        List<Particle<String, Double>> lp = new ArrayList<>();
        System.out.println(Arrays.toString(lf.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(lp.getClass().getTypeParameters()));
    }
}
