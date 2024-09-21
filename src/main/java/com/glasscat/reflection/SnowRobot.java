package com.glasscat.reflection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnowRobot implements Robot {
    private String name;

    SnowRobot(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowRobot series 1000";
    }

    private List<Operation> ops = Arrays.asList(
            new Operation(
                    () -> "除雪",
                    () -> System.out.println("正在除雪")
            ),
            new Operation(
                    () -> "堆雪人",
                    () -> System.out.println("正在堆雪人")
            )
    );

    @Override
    public List<Operation> operations() {
        return ops;
    }


    public static void main(String[] args) {
        Robot.test(new SnowRobot("xiaoming"));
    }
}
