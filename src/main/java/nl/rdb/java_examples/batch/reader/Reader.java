package nl.rdb.java_examples.batch.reader;

import java.util.List;

public interface Reader<T> {

    List<T> read();
}
