package nl.rdb.java_examples.pokemon;

public enum Nature {
    GENTLE(StatsType.ATT, StatsType.SP_DEF);

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
