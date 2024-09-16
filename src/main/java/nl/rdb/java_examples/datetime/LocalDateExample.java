package nl.rdb.java_examples.datetime;

import java.time.Duration;
import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class LocalDateExample {

    @Example
    void durationBetweenExample() {
        LocalDate date1 = LocalDate.now();
        LocalDate same = LocalDate.now();
        LocalDate future = LocalDate.now().plusDays(2);
        LocalDate past = LocalDate.now().minusDays(2);

        log.info("Same value output: {}", Duration.between(date1.atStartOfDay(), same.atStartOfDay()).toDays());
        log.info("Future value output: {}", Duration.between(date1.atStartOfDay(), future.atStartOfDay()).toDays());
        log.info("Past value output: {}", Duration.between(date1.atStartOfDay(), past.atStartOfDay()).toDays());
    }
}
