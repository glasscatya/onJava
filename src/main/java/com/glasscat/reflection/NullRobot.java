package com.glasscat.reflection;

import com.glasscat.onjava.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class NullRobotProxyHandler implements InvocationHandler {
    private String nullName;
    //在调用处理器中，直接实现了一个实例。  所以不需要传入实例。
    private Robot proxied = new NRobot();

    NullRobotProxyHandler(Class<? extends Robot> type) {
        nullName = type.getSimpleName() + " NullRobot";
    }

    //实现了预留的Null接口，以表示该类型为Null
    class NRobot implements Null, Robot {
        @Override
        public String name() {
            return nullName;
        }

        @Override
        public String model() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied, args);
    }
}

public class NullRobot {
    //可以使用该方法 测试所有类型Robot为Null的情况。
    public static Robot newNullRobot(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[]{Null.class, Robot.class},
                new NullRobotProxyHandler(type));
    }

    public static void main(String[] args) {
        Stream.of(
                new SnowRobot("王二狗"),
                newNullRobot(SnowRobot.class)
        ).forEach(Robot::test);
    }
}
