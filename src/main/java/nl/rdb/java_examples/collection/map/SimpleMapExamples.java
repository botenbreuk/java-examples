package nl.rdb.java_examples.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class SimpleMapExamples {

    @Example
    void filterMap() {
        Map<String, User> map = new HashMap<>();
        map.put("apple", new User("apple", "password"));
        map.put("banana", new User("banana", "1234"));
        map.put("strawberry", new User("strawberry", "password123"));

        List<String> fruits = List.of("orange", "apple", "banana");
        List<User> newArr = new ArrayList<>();
        fruits.stream()
                .map(map::get)
                .filter(Objects::nonNull)
                .findFirst()
                .ifPresent(newArr::add);
        newArr.forEach(v -> log.info("{}", v.username));
    }

    private record User(String username, String password) {}
}
