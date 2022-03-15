package nl.rdb.java_examples.pokemon.pokemon_kinds;

import static nl.rdb.java_examples.pokemon.PokemonType.FIRE;

import java.util.Collections;
import java.util.List;

import nl.rdb.java_examples.pokemon.Evolution;
import nl.rdb.java_examples.pokemon.Gender;
import nl.rdb.java_examples.pokemon.Nature;
import nl.rdb.java_examples.pokemon.Pokemon;
import nl.rdb.java_examples.pokemon.PokemonStats;
import nl.rdb.java_examples.pokemon.PokemonType;

public class Charmeleon extends Pokemon {

    public Charmeleon(int level, List<PokemonType> types, Nature nature, PokemonStats baseStats, Gender gender, Evolution evolution) {
        super(2, "Charmeleon", level, Collections.singletonList(FIRE), nature, baseStats, gender, evolution);
    }
}
