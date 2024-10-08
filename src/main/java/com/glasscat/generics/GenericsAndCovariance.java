package com.glasscat.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        //只读通配符，他能确读到的类都是Fruit和其子类。
        List<? extends Fruit> flist = new ArrayList<>();
        //compile Error
        //flist.add(new Fruit());
    }
}
