package com.glasscat.reflection;

import com.glasscat.reflection.interfacea.A;
import com.glasscat.reflection.packageaccess.HiddenC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HiddenImplementation {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        A a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getSimpleName());
        //找不到符号C C是包访问权限。
        //if (a instanceof C)

        //使用反射强行调用
        callHiddenMethod(a, "g");
        callHiddenMethod(a, "v");
    }

    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //getClass会获得实际类
        Method m = a.getClass().getDeclaredMethod(methodName);
        System.out.println("实际类型为" + a.getClass());
        m.setAccessible(true);
        m.invoke(a);
    }
}
