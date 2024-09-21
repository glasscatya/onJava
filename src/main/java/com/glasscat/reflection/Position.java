package com.glasscat.reflection;

import java.util.Optional;

class EmptyTitleException extends RuntimeException {
}


class Position {
    private String title;
    private Person person;

    Position(String jobTitle, Person employee) {
        setTitle(jobTitle);
        setEmployee(employee);
    }

    Position(String jobTitle) {
        this(jobTitle, null);
    }

    public void setTitle(String newTitle) {
        title = Optional.ofNullable(newTitle)
                        .orElseThrow(EmptyTitleException::new);
    }

    public void setEmployee(Person newEmployee) {
        person = Optional.ofNullable(newEmployee)
                         .orElse(new Person());
    }

    public Person getPerson() {
        return person;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Position("ceo"));
        System.out.println(new Position("CTO", new Person("xiao", "ming", "银河系第六旋臂太阳系地球村")));

        try {
            new Position(null);
        } catch (Exception e) {
            System.out.println("caught : " + e);
        }
    }
}
