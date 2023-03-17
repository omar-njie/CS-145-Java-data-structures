package com.omar.learn.java_streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Omar
 * @version 10/7/22
 */
public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach
       /*

       List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }
        females.forEach(System.out::println);

        */

        // Declarative approach

        // Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE)).toList();
        // females.forEach(System.out::println);
        // Sort
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender)/*.reversed()*/).toList();

        sorted.forEach(System.out::println);
        // All match
        // Any match
        // None match
        // Max
        // Min
        // Group
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Tim", 20, Gender.MALE),
                new Person("Omar", 19, Gender.MALE),
                new Person("Sara", 23, Gender.FEMALE),
                new Person("Clara", 25, Gender.FEMALE)
        );
    }
}
