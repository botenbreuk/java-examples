package com.example.java_examples.pokemon.pokemon_kinds;

import static com.example.java_examples.pokemon.PokemonType.FIRE;

import java.util.Collections;

import com.example.java_examples.pokemon.Evolution;
import com.example.java_examples.pokemon.Gender;
import com.example.java_examples.pokemon.Nature;
import com.example.java_examples.pokemon.Pokemon;
import com.example.java_examples.pokemon.PokemonStats;

public class Charmander extends Pokemon {

    public Charmander(String naam, int level, Nature nature, PokemonStats baseStats, Gender gender) {
        super(1, naam, level, Collections.singletonList(FIRE), nature, baseStats, gender, new Evolution(16, Charmeleon.class));
    }
}
