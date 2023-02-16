package nl.rdb.java_examples.utils;

import java.util.List;
import java.util.function.ObjIntConsumer;

public class ListUtils<T> {

    private final List<T> list;

    private ListUtils(List<T> list1) {this.list = list1;}

    public static <T> ListUtils<T> of(List<T> list) {
        return new ListUtils<>(list);
    }

    public void forEach(ObjIntConsumer<T> fn) {
        if (list == null || list.isEmpty()) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            T value = list.get(i);
            fn.accept(value, i);
        }
    }

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
