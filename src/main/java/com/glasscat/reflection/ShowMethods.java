package com.glasscat.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
    private static String usage = "usage\n" + "ShowMethods qualified.class.name\n"
            + "To show all methods in class or:\n" + "ShowMethods qulified.class.name word\n"
            + "To search for methods involving 'word'";

    private static Pattern p = Pattern.compile("\\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(1);
        }

        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            //当只传入要查询的类时
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(
                            p.matcher(method.toString())
                             .replaceAll("")
                    );
                }
                for (Constructor<?> ctor : constructors) {
                    System.out.println(
                            p.matcher(ctor.toString())
                             .replaceAll("")
                    );
                }
                lines = methods.length + constructors.length;
            } else {
                //当传入search时。
                for (Method method : methods) {
                    if (method.toString().contains(args[1])) {
                        System.out.println(
                                p.matcher(method.toString())
                                 .replaceAll("")
                        );
                        lines++;
                    }
                }
                for (Constructor ctor : constructors)
                    if (ctor.toString().contains(args[1])) {
                        System.out.println(
                                p.matcher(ctor.toString())
                                 .replaceAll(""));
                        lines++;
                    }
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
