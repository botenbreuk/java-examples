package nl.rdb.java_examples.builder.advanced;

public interface AbstractBuildCommand<T> {

    T getInternalObject();

    T build();
}
