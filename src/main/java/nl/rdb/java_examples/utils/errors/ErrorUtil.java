package nl.rdb.java_examples.utils.errors;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorUtil {

    private static final String LOG_MESSAGE = "Message: {}";

    private static Map<String, List<String>> errors = new HashMap<>();

    private ErrorUtil() {}

    public static <T> T logErrors(String list, Callable<T> runnable) {
        try {
            return runnable.call();
        } catch (Exception ex) {
            addError(list, ex);
            return null;
        }
    }

    public static void logException(String list, Callable<Void> runnable) {
        try {
            runnable.call();
        } catch (Exception ex) {
            addError(list, ex);
        }
    }

    public static <T> T logErrors(Callable<T> runnable) {
        try {
            return runnable.call();
        } catch (Exception ex) {
            if (log.isDebugEnabled()) {
                log.debug(LOG_MESSAGE, ex.getMessage(), ex);
            } else {
                log.error(LOG_MESSAGE, ex.getMessage());
            }
            return null;
        }
    }

    public static Map<String, List<String>> getErrors() {
        return errors;
    }

    public static void clearError() {
        errors = new HashMap<>();
    }

    public static void addError(String key, Exception ex) {
        if (log.isDebugEnabled()) {
            log.debug(LOG_MESSAGE, ex.getMessage(), ex);
        } else {
            log.error(LOG_MESSAGE, ex.getMessage());
        }
        List<String> e = errors.get(key);
        String message = "Something went wrong. Reason: %s".formatted(ex.getMessage());

        if (e == null) {
            errors.put(key, Collections.singletonList(message));
        } else {
            e.add(message);
        }
    }
}
