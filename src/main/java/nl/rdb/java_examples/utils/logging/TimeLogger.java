package nl.rdb.java_examples.utils.logging;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.time.StopWatch;

@Slf4j
public class TimeLogger {

    private TimeLogger() {throw new IllegalStateException("Utility class");}

    public static void logDuration(String name, String message, Runnable function) {
        StopWatch stopWatch = StopWatch.createStarted();
        function.run();
        stopWatch.stop();
        log.info("{} > {} took {} ms", name, message, stopWatch.getTime());
    }

    public static void logTimeStartFinish(String name, String message, Runnable function) {
        StopWatch stopWatch = StopWatch.createStarted();
        log.info("{} > Started: {}", name, message);
        function.run();
        stopWatch.stop();
        log.info("{} > Finished: {} took {} ms", name, message, stopWatch.getTime());
    }

    public static void logStartFinish(String name, String message, Runnable function) {
        log.info("{} > Started: {}", name, message);
        function.run();
        log.info("{} > Finished: {}", name, message);
    }
}
