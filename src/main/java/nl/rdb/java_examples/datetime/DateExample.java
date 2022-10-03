package nl.rdb.java_examples.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class DateExample {

    public String formatCurrentDate(String format) {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return localDate.format(formatter);
    }

    public LocalDate addDays(LocalDate date, int days) {
        return date.plusMonths(3);
    }

    @Example
    public void dateExample() {
        DateExample dateExample = new DateExample();
        log.info("{}", dateExample.addDays(LocalDate.of(2017, 11, 2), 3));
        log.info(dateExample.formatCurrentDate("yyyyMMdd"));
    }
}
