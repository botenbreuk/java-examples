package com.example.java_examples.time;

import static org.junit.Assert.assertEquals;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class LocalDateTimeExampleTest {

    @Test
    public void formatDateToString() {
        LocalDateTime time = LocalDateTime.of(2020, Month.NOVEMBER, 2, 0, 0);
        LocalDateTimeExample example = new LocalDateTimeExample(time);

        String expected = "2020-11-02 12:00:00";
        String actual = example.getOrdinaryYearFormat();

        assertEquals(expected, actual);
    }

    @Test
    public void parseDateToString() {
        String time = "02-11-2020 14:10";
        LocalDateTimeExample example = new LocalDateTimeExample();

        LocalDateTime expected = LocalDateTime.of(2020, Month.NOVEMBER, 2, 0, 0);
        ;
        LocalDateTime actual = example.parse("dd-MM-yyyy hh:mm", time);

        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println(MethodHandles.lookup().lookupClass());
    }
}
