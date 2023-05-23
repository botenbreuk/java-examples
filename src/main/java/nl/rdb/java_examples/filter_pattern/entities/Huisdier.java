package nl.rdb.java_examples.filter_pattern.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public final class Huisdier {

    private final String naam;
    private final HuisdierType type;
}
