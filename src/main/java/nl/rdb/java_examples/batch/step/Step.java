package nl.rdb.java_examples.batch.step;

import java.util.List;

public interface Step<T> {

    void execute(List<T> values);

    default void onFail() {}
}
