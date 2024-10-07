package nl.rdb.java_examples.optional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class OptionalExample {

    @Example
    void optionalMapAndCast() {
        Map<String, Object> map = new HashMap<>();
        map.put("test", "String");
        map.put("test2", 2);

        Optional.ofNullable(map.get("test"))
                .map(String.class::cast)
                .ifPresent(v -> log.info("Value = {}", v));

        Optional.ofNullable(map.get("test2"))
                .map(Integer.class::cast)
                .ifPresent(v -> log.info("Value = {}", v));

        Optional.ofNullable(map.get("test3"))
                .map(String.class::cast)
                .ifPresentOrElse(
                        v -> log.info("Value = {}", v),
                        () -> log.error("Something went wrong")
                );
    }

    @Example
    void optionalFilter() {
        Optional<Person> str = Optional.of(new Person("Pietje", 21));
        int age = str
                .filter(value -> value.name.equals("Pietje"))
                .map(value -> value.age)
                .orElse(1);
        log.info("Age is: {}", age);
    }

    @Example
    void optionalFilterNull() {
        Optional<Person> str = Optional.ofNullable(null);
        int age = str
                .filter(value -> value.name.equals("Pietje"))
                .map(value -> value.age)
                .orElse(1);
        log.info("Age is: {}", age);
    }

    @Example
    void optionalList() {
        List<Optional<Person>> optionals = List.of(Optional.of(new Person("Pietje", 21)), Optional.ofNullable(null), Optional.of(new Person("Jantje", 21)));
        var list = optionals.stream()
                .map(p -> p.map(Person::name).orElse(null))
                .collect(Collectors.joining(", "));
        log.info("{}", list);
    }

    private record Person(String name, int age) {}
}
