package com.coding;

import com.coding.learnings.Person;
import com.coding.learnings.PersonComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("John", 15),
                new Person("Sam", 25),
                new Person("Will", 20),
                new Person("Dan", 20),
                new Person("Joe", 10)
        ));
        persons.sort(new PersonComparator());
        System.out.println(persons);
    }
}

