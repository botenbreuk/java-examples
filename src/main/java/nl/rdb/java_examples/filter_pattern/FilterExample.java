package nl.rdb.java_examples.filter_pattern;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.filter_pattern.entities.Gebruiker;
import nl.rdb.java_examples.filter_pattern.entities.Huisdier;
import nl.rdb.java_examples.filter_pattern.entities.HuisdierType;
import nl.rdb.java_examples.filter_pattern.filters.CanDrinkAlcoholFilter;
import nl.rdb.java_examples.filter_pattern.filters.HasPetFilter;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class FilterExample {

    @Example
    public void filter() {
        List<Gebruiker> gebruikers = new ArrayList<>();

        gebruikers.add(new Gebruiker("Jan", "jan@email.nl", 17, new ArrayList<>()));
        gebruikers.add(new Gebruiker("Pier", "pier@email.nl", 21, List.of(new Huisdier("Astor", HuisdierType.HOND))));
        gebruikers.add(new Gebruiker("Jaap", "jaap@email.nl", 32, new ArrayList<>()));
        gebruikers.add(new Gebruiker("Naam", "naam@email.nl", 14, new ArrayList<>()));

        FilterBuilder<Gebruiker> builder = new FilterBuilder<>();
        List<Gebruiker> filtered = builder.toFilter(gebruikers)
                .add(new CanDrinkAlcoholFilter())
                .add(new HasPetFilter())
                .toList();

        if (filtered.isEmpty()) {
            log.info("No users");
            return;
        }
        filtered.forEach(g -> log.info("Gebruiker {} - {}", g.getNaam(), g.getAge()));
    }
}
