package nl.rdb.java_examples.pokemon;

public enum TypeEffectiveness {
    SUPER_EFFECTIVE(2),
    EFFECTIVE(1.5),
    NORMAL(1),
    NOT_VERY_EFFECTIVE(0.5);

    private double multiplier;

    TypeEffectiveness(double multiplier) {
        this.multiplier = multiplier;
    }
}
