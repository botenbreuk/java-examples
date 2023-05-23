package nl.rdb.java_examples.filter_pattern.filters;

import nl.rdb.java_examples.filter_pattern.EntityFilter;
import nl.rdb.java_examples.filter_pattern.entities.Huisdier;
import nl.rdb.java_examples.filter_pattern.entities.HuisdierType;

public class IsDogFilter implements EntityFilter<Huisdier> {

    @Override
    public boolean filter(Huisdier value) {
        return value.getType() == HuisdierType.HOND;
    }
}
