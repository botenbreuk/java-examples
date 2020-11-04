package com.example.java_examples.pokemon;

import java.util.List;

public abstract class Pokemon {

    private int dexNumber;
    private String naam;

    private int level;
    private int maxExp;
    private List<PokemonType> types;
    private Nature nature;
    private PokemonStats baseStats;
    private Gender gender;

    private Evolution evolution;

    public Pokemon(int dexNumber, String naam, int level, List<PokemonType> types, Nature nature, PokemonStats baseStats, Gender gender, Evolution evolution) {
        this.dexNumber = dexNumber;
        this.naam = naam;
        this.level = level;
        this.types = types;
        this.nature = nature;
        this.baseStats = baseStats;
        this.gender = gender;
        this.evolution = evolution;
    }

    public int getDexNumber() {
        return dexNumber;
    }

    public String getNaam() {
        return naam;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public Nature getNature() {
        return nature;
    }

    public PokemonStats getBaseStats() {
        return baseStats;
    }

    public Gender getGender() {
        return gender;
    }

    public Evolution getEvolution() {
        return evolution;
    }

    public boolean canEvolve() {
        return level >= evolution.getLevel();
    }
}
