package nl.rdb.java_examples.collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class TreeMapExample {

    @Example(name = "TreeMap sorting example")
    void treeMapSorting() {
        Comparator<String> comparator = Comparator.comparing(str -> str);
        Map<String, Integer> map = new TreeMap<>(comparator);

        map.put("banaan", 1);
        map.put("appel", 2);
        map.put("kiwi", 25);

        map.forEach((k, v) -> log.info("Key: {}, value: {}", k, v));
    }

    @Example(name = "TreeMap sorting with Objects as keys example")
    void treeMapSortingObjectKeys() {
        Comparator<Person> comparator = Comparator.comparing(Person::name).thenComparing(Person::age);
        Map<Person, Class> map = new TreeMap<>(comparator);

        Person person1 = new Person("Piet", 32);
        Person person2 = new Person("Jaap", 48);
        Person person3 = new Person("Gert", 25);
        Person person4 = new Person("Bert", 26);
        Person person5 = new Person("Johan", 109);
        Person person6 = new Person("Jaap", 19);

        map.put(person1, new Class("Math", "math"));
        map.put(person2, new Class("History", "hist"));
        map.put(person3, new Class("Dutch", "dutch"));
        map.put(person4, new Class("Math", "math"));
        map.put(person5, new Class("Programming", "program"));
        map.put(person6, new Class("Calculus", "calc"));

        map.forEach((k, v) -> log.info("Key: {} - {}, current class: {}", k.name, k.age, v.name));
    }

    private record Person(String name, int age) {}

    private record Class(String name, String shortName) {}
}
