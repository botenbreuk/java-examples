package com.example.java_examples.pokemon;

public class Evolution {

    private int level;
    private Class<? extends Pokemon> evolution;

    public Evolution(int level, Class<? extends Pokemon> evolution) {
        this.level = level;
        this.evolution = evolution;
    }

    public int getLevel() {
        return level;
    }

    public Class<? extends Pokemon> getEvolution() {
        return evolution;
    }
}
