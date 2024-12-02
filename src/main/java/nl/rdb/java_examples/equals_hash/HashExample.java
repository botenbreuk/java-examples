package nl.rdb.java_examples.equals_hash;

import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class HashExample {

    @Example
    void objectHashExample() {
        Person person = new Person("Naam", 30);
        int hash = Objects.hashCode("Naam");

        log.info("hash {}", hash);
        log.info("hashCode {}", person.hashCode());
        log.info("Is same? {}", hash == person.hashCode() ? "yup" : "nope");
    }

    private record Person(String name, int age) {

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Person that))
                return false;
            return Objects.equals(name(), that.name());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name());
        }
    }
}
