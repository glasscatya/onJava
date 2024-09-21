package com.glasscat.reflection;

import java.util.HashMap;

public class TypeCounter extends HashMap<Class<?>, Integer> {
    //想要统计的的基类
    private Class<?> baseType;

    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();
        //
        if(!type.isAssignableFrom(baseType)) {
            throw new RuntimeException(
                    obj + " incorrect type: " + type
            );
        }
        countClass(type);
    }

    private void countClass(Class<?> type) {
        Integer integer = get(type);
        put(type, integer == null ? 1 : integer + 1);

        Class<?> classSuper = type.getSuperclass();
        if(classSuper != null &&  classSuper.isAssignableFrom(baseType)) {
            countClass(classSuper);
        }
    }
}
