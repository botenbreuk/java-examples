package nl.rdb.java_examples.utils.logging;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.time.StopWatch;

/**
 * Utility class for logging the start and end of a method or code block.
 * Usage: TimeLogger.logTimeStartFinish("Name", "identifying message", () -> methodCall());
 */
@Slf4j
public class TimeLogger {

    private TimeLogger() {throw new IllegalStateException("Utility class");}

    public static void logTimeFinish(String name, String message, Runnable function) {
        StopWatch stopWatch = StopWatch.createStarted();
        function.run();
        stopWatch.stop();
        log.info("{} > {} took {}ms", name, message, stopWatch.getTime());
    }

    public static <T> T logTimeFinish(String name, String message, Supplier<T> function) {
        StopWatch stopWatch = StopWatch.createStarted();
        T result = function.get();
        stopWatch.stop();
        log.info("{} > {} took {}ms", name, message, stopWatch.getTime());
        return result;
    }

    public static <T> T logTimeStartFinish(String name, String message, Supplier<T> function) {
        StopWatch stopWatch = StopWatch.createStarted();
        log.info("{} > Started: {}", name, message);
        T result = function.get();
        stopWatch.stop();
        log.info("{} > Finished: {} took {}ms", name, message, stopWatch.getTime());
        return result;
    }

    public static void logTimeStartFinish(String name, String message, Runnable function) {
        StopWatch stopWatch = StopWatch.createStarted();
        log.info("{} > Started: {}", name, message);
        function.run();
        stopWatch.stop();
        log.info("{} > Finished: {} took {}ms", name, message, stopWatch.getTime());
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

    public static void logStartFinish(String name, String message, Runnable function) {
        log.info("{} > Started: {}", name, message);
        function.run();
        log.info("{} > Finished: {}", name, message);
    }
}