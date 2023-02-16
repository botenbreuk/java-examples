package nl.rdb.java_examples.utils;

import java.util.List;
import java.util.function.ObjIntConsumer;

public class ListUtils {

    private ListUtils() {throw new IllegalStateException("Utility class");}

    public static <T> void forEach(List<T> collection, ObjIntConsumer<T> fn) {
        if (collection == null || collection.isEmpty()) {
            return;
        }

        for (int i = 0; i < collection.size(); i++) {
            T value = collection.get(i);
            fn.accept(value, i);
        }
    }
}
