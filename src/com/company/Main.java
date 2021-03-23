package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) {
        final int age = 18;
        final int size = 4;
        final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};

        Map<Object, Object> filtered = boys.stream()
                .filter(boy -> boy.getAge() >= age)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(size)
                .collect(Collectors.toMap(p -> p, t -> boys.stream().
                        filter(boy -> boy.getName().equals(t)).count() - 1));

        filtered.forEach((k, v) -> System.out.println(k + " " + v));

        // или
        System.out.println(filtered);
    }
}