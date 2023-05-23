package nl.rdb.java_examples.filter_pattern;

public interface EntityFilter<T> {

    boolean filter(T value);
}
