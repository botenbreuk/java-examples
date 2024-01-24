package nl.rdb.java_examples.optional;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class OptionalExample {

    @Example
    void optionalFilter() {
        Optional<Person> str = Optional.of(new Person("Pietje", 21));
        int age = str
                .filter(value -> value.name.equals("Pietje"))
                .map(value -> value.age)
                .orElse(1);
        log.info("Age is: {}", age);
    }

    private record Person(String name, int age) {}
}
