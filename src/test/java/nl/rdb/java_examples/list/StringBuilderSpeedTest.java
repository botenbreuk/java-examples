package nl.rdb.java_examples.list;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Slf4j
class StringBuilderSpeedTest {

    @ParameterizedTest
    @ValueSource(ints = { 10, 100, 1000, 10000, 50000 })
    void testSpeed_withoutBuilder(int times) {
        StringBuilder str = new StringBuilder();
        long start = System.currentTimeMillis();
        str.append("String".repeat(Math.max(0, times)));
        long end = System.currentTimeMillis();
        log.info("DEBUG: {} test took {} MilliSeconds", times, end - start);
    }

    @ParameterizedTest
    @ValueSource(ints = { 10, 100, 1000, 10000, 50000 })
    void testSpeed_withBuilder(int times) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        sb.append("String".repeat(Math.max(0, times)));
        long end = System.currentTimeMillis();
        log.info("DEBUG: {} test took {} MilliSeconds", times, end - start);
    }

    @Test
    void stringStreamJoining_doesNotContainComma() {
        List<String> testList = List.of("test");
        String test = String.join(", ", testList);

        assertFalse(test.contains(","));
    }

    @Test
    void stringStreamJoining_doesContainComma() {
        List<String> testList = List.of("test", "testing");
        String test = String.join(", ", testList);

        assertTrue(test.contains(","));
    }
}
