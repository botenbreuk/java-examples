package nl.rdb.java_examples.pokemon.pokemon_kinds;

import static nl.rdb.java_examples.pokemon.PokemonType.FIRE;

import java.util.Collections;

import nl.rdb.java_examples.pokemon.Evolution;
import nl.rdb.java_examples.pokemon.Gender;
import nl.rdb.java_examples.pokemon.Nature;
import nl.rdb.java_examples.pokemon.Pokemon;
import nl.rdb.java_examples.pokemon.PokemonStats;

public class Charmander extends Pokemon {

    public Charmander(String naam, int level, Nature nature, PokemonStats baseStats, Gender gender) {
        super(1, naam, level, Collections.singletonList(FIRE), nature, baseStats, gender, new Evolution(16, Charmeleon.class));
    }
}
