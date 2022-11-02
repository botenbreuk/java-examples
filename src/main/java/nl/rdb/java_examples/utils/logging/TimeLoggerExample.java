package nl.rdb.java_examples.utils.logging;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class TimeLoggerExample {

    @Example
    public void timeLogger() {
        TimeLogger.logTimeFinish("Testing the timelogger", () -> log.info("I have meen called"));
    }
}
