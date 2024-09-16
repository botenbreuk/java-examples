package nl.rdb.java_examples.utils.logging;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

import com.google.common.collect.Lists;

@Slf4j
public class TimeLoggerExample {

    @Example(name = "TimeLogger with Name as parameter")
    void timeLoggerWithName() {
        String name = getClass().getSimpleName();

        TimeLogger.logTimeFinish(name, "Testing the Timelogger only finish", () -> log.info("I have meen called"));

        String hello = TimeLogger.logTimeFinish(name, "Testing the Timelogger finish with return", () -> "Returned Hello world!");
        log.info("Message: {}", hello);

        String helloWorld = TimeLogger.logTimeStartFinish(name, "Testing the Timelogger start and finish with return", () -> "Hello world TWO!");
        log.info("Message: {}", helloWorld);

        TimeLogger.logTimeStartFinish(name, "Testing the Timelogger start and finish", () -> log.info("I have meen called"));

        List<String> testVar = Lists.newArrayList("Hello", "World");
        List<String> testingVar = TimeLogger.logTimeStartFinishUn(name, "Testing return value", testVar, list -> {
            list.add("!");
            return list;
        });
        log.info("Message: {}", String.join(" ", testingVar));

        List<String> testVar2 = Lists.newArrayList("Hello", "World");
        String testingVar2 = TimeLogger.logTimeStartFinishFn(name, "Testing return value", testVar2, list -> {
            list.add("!");
            return String.join(" ", list);
        });
        log.info("Message: {}", testingVar2);

        List<String> first = Lists.newArrayList("Hallo", "Wereld", "!");
        List<String> second = Lists.newArrayList("Hello", "World", "!");
        List<List<String>> parts = Lists.newArrayList(first, second);
        TimeLogger.logTimeStartFinish(name, "Testing partitions", parts, part -> log.info("Joining parts: {}", String.join(" ", part)));

        TimeLogger.logStartFinish(name, "Testing timelogger with sleep", () -> {
            try {
                Thread.sleep(300);
                log.info("Start finish");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        TimeLogger.logTimeStartFinish(name, "Testing timelogger with sleep and time", () -> {
            try {
                Thread.sleep(321);
                log.info("Start finish time");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Example
    void timeLogger() {
        TimeLogger.logTimeFinish("Testing the Timelogger only finish", () -> log.info("I have meen called"));

        String hello = TimeLogger.logTimeFinish("Testing the Timelogger finish with return", () -> "Returned Hello world!");
        log.info("Message: {}", hello);

        String helloWorld = TimeLogger.logTimeStartFinish("Testing the Timelogger start and finish with return", () -> "Hello world TWO!");
        log.info("Message: {}", helloWorld);

        TimeLogger.logTimeStartFinish("Testing the Timelogger start and finish", () -> log.info("I have meen called"));

        List<String> testVar = Lists.newArrayList("Hello", "World");
        List<String> testingVar = TimeLogger.logTimeStartFinishUn("Testing return value", testVar, list -> {
            list.add("!");
            return list;
        });
        log.info("Message: {}", String.join(" ", testingVar));

        List<TestString> listHW = Lists.newArrayList(
                new TestString("Hello"),
                new TestString("World")
        );
        String testingVar2 = TimeLogger.logTimeStartFinishFn("Testing return different type value", listHW, testList -> {
            testList.add(new TestString("!"));
            return String.join(" ", testList.stream().map(TestString::label).toList());
        });
        log.info("Message: {}", testingVar2);

        List<String> first = Lists.newArrayList("Hallo", "Wereld", "!");
        List<String> second = Lists.newArrayList("Hello", "World", "!");
        List<List<String>> parts = Lists.newArrayList(first, second);
        TimeLogger.logTimeStartFinish("Testing partitions", parts, part -> log.info("Joining parts: {}", String.join(" ", part)));

        TimeLogger.logStartFinish("Testing timelogger with sleep", () -> log.info("Start finish"));
    }

    private record TestString(String label) {}
}
