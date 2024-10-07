package nl.rdb.java_examples.collection.list;

import static java.util.Collections.disjoint;
import static nl.rdb.java_examples.collection.list.PetType.CAT;
import static nl.rdb.java_examples.collection.list.PetType.DOG;
import static nl.rdb.java_examples.collection.list.PetType.FISH;
import static nl.rdb.java_examples.collection.list.PetType.HAMSTER;
import static org.apache.commons.collections4.CollectionUtils.disjunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ListExample {

    @Example
    void collectorsJoining() {
        List<PetType> pets = List.of(DOG, CAT, HAMSTER, FISH);
        List<PetType> empty = new ArrayList<>();

        String joined = pets.stream()
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        String joinedEmpty = empty.stream()
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        log.info("Joining enum: {}", joined);
        log.info("Joining empty list: {}", joinedEmpty.isEmpty() ? "Empty string" : "Something else");
    }

    @Example
    void disjunctionExample() {
        List<PetType> pets1 = List.of(DOG, CAT);
        List<PetType> pets2 = List.of(DOG, CAT, HAMSTER, FISH);

        String joined = disjunction(pets1, pets2).stream()
                .map(Enum::name)
                .collect(Collectors.joining(", "));

        log.info("Disjunction: {}", joined);
    }

    @Example
    void disjointExample() {
        List<PetType> pets1 = List.of(DOG, CAT);
        List<PetType> pets2 = List.of(DOG, HAMSTER, FISH);

        boolean has = disjoint(pets1, pets2);

        log.info("Disjoint: {}", has);

        pets2 = List.of(HAMSTER, FISH);
        has = disjoint(pets1, pets2);

        log.info("Disjoint: {}", has);
    }

    @Example
    void anyMatchExample() {
        List<String> listOfLetters = Arrays.asList("a", "b", "c", "d");

        boolean shouldBeTrue = listOfLetters.stream()
                .anyMatch(List.of("d", "e", "f", "g")::contains);
        log.info("Has overlapping items: {}", shouldBeTrue);

        boolean shouldBeFalse = listOfLetters.stream()
                .anyMatch(List.of("London", "Berlin", "Paris", "Brussels")::contains);
        log.info("shouldBeFalse: {}", shouldBeFalse);
    }
}

enum PetType {
    DOG,
    CAT,
    HAMSTER,
    GUINEA_PIG,
    FISH
}