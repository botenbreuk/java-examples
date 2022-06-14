package nl.rdb.java_examples.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ObjectsTest {

    @Nested
    @DisplayName("Private method object setter")
    class PrivateMethodObjectTest {

        @Test
        @DisplayName("is should set object variables inside private method")
        void testPrivateMethod() {
            Person person = new Person("Naam", 24);

            setValues(person);

            assertEquals("Nieuwe naam", person.getNaam());
            assertEquals(28, person.getAge());
        }

        private void setValues(Person person) {
            person.setNaam("Nieuwe naam");
            person.setAge(28);
        }

        @Getter
        @Setter
        @AllArgsConstructor
        private static class Person {
            private String naam;
            private int age;
        }
    }
}
