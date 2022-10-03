package nl.rdb.java_examples.datetime;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class DateTimeExample {

    @Example
    public void dateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2018, 11, 02, 12, 32, 22, 300);
        log.info(dateTime.toLocalTime().toString());
    }

    @Example
    public void timeUnitExample() {
        log.info("{}", TimeUnit.HOURS.toMillis(1));
    }
}
