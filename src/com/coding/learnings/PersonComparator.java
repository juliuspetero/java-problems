package com.coding.learnings;

import java.util.Comparator;

/**
 * List<Person> persons = new ArrayList<>(Arrays.asList(
 * new Person("John", 15),
 * new Person("Sam", 25),
 * new Person("Will", 20),
 * new Person("Dan", 20),
 * new Person("Joe", 10)
 * ));
 * <p>
 * persons.sort(new PersonComparator());
 * System.out.println(persons);
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() != o2.getAge()) {
            return o1.getAge() - o2.getAge();
        }
        return o1.getName().compareTo(o2.getName());
    }
}


