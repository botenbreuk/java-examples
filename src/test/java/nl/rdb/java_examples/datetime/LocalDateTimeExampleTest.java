package nl.rdb.java_examples.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import nl.rdb.java_examples.time.LocalDateTimeExample;

import org.junit.jupiter.api.Test;

class LocalDateTimeExampleTest {

    @Test
    void fomatTest() {
        LocalDateTimeExample example = new LocalDateTimeExample(LocalDateTime.of(2019, Month.DECEMBER, 31, 8, 15, 0));
        assertEquals("2019-12-31 08:15:00", example.getOrdinaryYearFormat());
        assertEquals("2020-12-31 08:15:00", example.getWeekBasedYearFormat());
    }
}
