package nl.rdb.java_examples.utils.logging;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.time.StopWatch;

/**
 * Utility class for logging the start and end of a method or code block.
 * Usage: TimeLogger.logTimeStartFinish("Name", "identifying message", () -> methodCall());
 */
@Slf4j
public class TimeLogger {

    private static final String METHOD_STRING = "Method: \"%s\". Message: %s";

    private TimeLogger() {throw new IllegalStateException("Utility class");}

    public static void logTimeFinish(String name, String message, Runnable function) {
        StopWatch stopWatch = StopWatch.createStarted();
        function.run();
        stopWatch.stop();
        log.info("{} > {} took {}ms", name, message, stopWatch.getTime());
    }

    public static void logTimeFinish(String message, Runnable function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        logTimeFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), function);
    }

    public static <T> T logTimeFinish(String name, String message, Supplier<T> function) {
        StopWatch stopWatch = StopWatch.createStarted();
        T result = function.get();
        stopWatch.stop();
        log.info("{} > {} took {}ms", name, message, stopWatch.getTime());
        return result;
    }

    public static <T> T logTimeFinish(String message, Supplier<T> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        return logTimeFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), function);
    }

    public static <T> T logTimeStartFinish(String name, String message, Supplier<T> function) {
        StopWatch stopWatch = startTime(name, message);
        T result = function.get();
        stopTIme(stopWatch, name, message);
        return result;
    }

    public static <T> T logTimeStartFinish(String message, Supplier<T> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        return logTimeStartFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), function);
    }

    public static void logTimeStartFinish(String name, String message, Runnable function) {
        StopWatch stopWatch = startTime(name, message);
        function.run();
        stopTIme(stopWatch, name, message);
    }

    public static <T> T logTimeStartFinishUn(String name, String message, T obj, UnaryOperator<T> function) {
        StopWatch stopWatch = startTime(name, message);
        T result = function.apply(obj);
        stopTIme(stopWatch, name, message);
        return result;
    }

    public static <T> T logTimeStartFinishUn(String message, T obj, UnaryOperator<T> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        return logTimeStartFinishUn(calledBy.getShortClass(), message, obj, function);
    }

    public static <T, R> R logTimeStartFinishFn(String name, String message, T obj, Function<T, R> function) {
        StopWatch stopWatch = startTime(name, message);
        R result = function.apply(obj);
        stopTIme(stopWatch, name, message);
        return result;
    }

    public static <T, R> R logTimeStartFinishFn(String message, T obj, Function<T, R> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        return logTimeStartFinishFn(calledBy.getShortClass(), message, obj, function);
    }

    public static void logTimeStartFinish(String message, Runnable function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        logTimeStartFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), function);
    }

    public static <T> void logTimeStartFinish(String name, String message, List<List<T>> partitions, Consumer<List<T>> function) {
        final int total = partitions.size();

        for (int i = 0; i < total; i++) {
            StopWatch stopWatch = StopWatch.createStarted();
            log.info("{} > Started: List {} of the {} lists for {}", name, i + 1, total, message);
            function.accept(partitions.get(i));
            stopWatch.stop();
            log.info("{} > Finished: List {} of the {} lists for {} took {}ms", name, i + 1, total, message, stopWatch.getTime());
        }
    }

    public static <T> void logTimeStartFinish(String message, List<List<T>> partitions, Consumer<List<T>> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        logTimeStartFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), partitions, function);
    }

    public static void logStartFinish(String name, String message, Runnable function) {
        log.info("{} > Started: {}", name, message);
        function.run();
        log.info("{} > Finished: {}", name, message);
    }

    public static <T> T logStartFinish(String message, T obj, UnaryOperator<T> function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        log.info("{} > Started: {}", calledBy.getShortClass(), message);
        T result = function.apply(obj);
        log.info("{} > Finished: {}", calledBy.getShortClass(), message);
        return result;
    }

    public static void logStartFinish(String message, Runnable function) {
        CalledByClassMethod calledBy = new CalledByClassMethod();
        logStartFinish(calledBy.getShortClass(), calledBy.getClassMethod(message), function);
    }

    private static StopWatch startTime(String name, String message) {
        log.info("{} > Started: {}", name, message);
        return StopWatch.createStarted();
    }

    private static void stopTIme(StopWatch stopWatch, String name, String message) {
        stopWatch.stop();
        log.info("{} > Finished: {} took {}ms", name, message, stopWatch.getTime());
    }

    private static final class CalledByClassMethod {
        private final String className;
        private final String methodName;

        private CalledByClassMethod() {
            StackTraceElement trace = Arrays.stream(new Throwable().getStackTrace()).limit(5).toList().get(2);
            this.className = trace.getClassName();
            this.methodName = trace.getMethodName();
        }

        public String getShortClass() {return Arrays.stream(className.split("\\.")).reduce((first, second) -> second).orElse("");}

        public String getClassMethod() {
            return "%s::%s()".formatted(getShortClass(), this.methodName);
        }

        public String getClassMethod(String message) {
            return METHOD_STRING.formatted(getClassMethod(), message);
        }
    }
}