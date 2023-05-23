package nl.rdb.java_examples.filter_pattern.filters;

import nl.rdb.java_examples.filter_pattern.EntityFilter;
import nl.rdb.java_examples.filter_pattern.entities.Gebruiker;

public class HasPetFilter implements EntityFilter<Gebruiker> {

    @Override
    public boolean filter(Gebruiker value) {
        return value.getPets() != null && !value.getPets().isEmpty();
    }
}
