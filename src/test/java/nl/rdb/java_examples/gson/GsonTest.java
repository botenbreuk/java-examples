package nl.rdb.java_examples.gson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

    @Nested
    class LocalDateConversionTest {

        @Test
        @DisplayName("it should successfully convert LocalDate")
        void convertLocalDate_shouldSucceed() {
            Person person = new Person("Piet", LocalDate.of(1993, 1, 1));

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            String json = gson.toJson(person);

            assertEquals("{\"naam\":\"Piet\",\"birthDay\":\"1993-01-01\"}", json);

            Person toObject = gson.fromJson("{\"naam\":\"Piet\",\"birthDay\":\"1993-01-01\"}", Person.class);
            assertEquals(toObject.getNaam(), person.getNaam());
            assertEquals(toObject.getBirthDay(), person.getBirthDay());
        }

        @Getter
        @Setter
        @AllArgsConstructor
        private static class Person {
            private String naam;
            private LocalDate birthDay;
        }
    }

    @Nested
    class LocalDateTimeConversionTest {

        @Test
        @DisplayName("it should successfully convert LocalDateTime")
        void convertLocalDateTime_shouldSucceed() {
            Person person = new Person("Piet", LocalDateTime.of(1993, 1, 1, 14, 11, 0));

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).create();
            String json = gson.toJson(person);

            assertEquals("{\"naam\":\"Piet\",\"birthDay\":\"1993-01-01 14:11:00\"}", json);

            Person toObject = gson.fromJson("{\"naam\":\"Piet\",\"birthDay\":\"1993-01-01 14:11:00\"}", Person.class);
            assertEquals(toObject.getNaam(), person.getNaam());
            assertEquals(toObject.getBirthDay(), person.getBirthDay());
        }

        @Getter
        @Setter
        @AllArgsConstructor
        private static class Person {
            private String naam;
            private LocalDateTime birthDay;
        }
    }
}
