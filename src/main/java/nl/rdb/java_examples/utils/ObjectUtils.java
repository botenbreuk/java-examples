package nl.rdb.java_examples.utils;

import java.util.Optional;

public class ObjectUtils {

    private ObjectUtils() {throw new IllegalStateException("Utility class");}

    public static <T> T getOrDefault(T value, T defaultValue) {
        return Optional.ofNullable(value).orElse(defaultValue);
    }
}
