package nl.rdb.java_examples.filter_pattern.filters;

import nl.rdb.java_examples.filter_pattern.EntityFilter;
import nl.rdb.java_examples.filter_pattern.entities.Gebruiker;

public class CanDrinkAlcoholFilter implements EntityFilter<Gebruiker> {

    @Override
    public boolean filter(Gebruiker value) {
        return value.getAge() > 18;
    }
}
