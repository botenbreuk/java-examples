package com.example.java_examples.pokemon;

import static com.example.java_examples.pokemon.StatsType.ATT;
import static com.example.java_examples.pokemon.StatsType.SP_DEF;

public enum Nature {
    GENTLE(ATT, SP_DEF);

    private StatsType positiveEffect;
    private StatsType negativeEffect;

    Nature(StatsType positiveEffect, StatsType negativeEffect) {
        this.positiveEffect = positiveEffect;
        this.negativeEffect = negativeEffect;
    }

    public StatsType getPositiveEffect() {
        return positiveEffect;
    }

    public StatsType getNegativeEffect() {
        return negativeEffect;
    }
}
