package nl.rdb.java_examples.datetime;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ClockExample {

    private final LocalDateTime referenceDateTime = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am
    private final ZoneId defaultZone = ZoneId.systemDefault();
    private final Clock fixedClock = Clock.fixed(referenceDateTime.atZone(defaultZone).toInstant(), defaultZone);

    public LocalDateTime showTime() {
        return LocalDateTime.now(fixedClock);
    }

    public LocalDateTime showRealTime() {
        return LocalDateTime.now();
    }

    @Example
    public void showTimeFormat() {
        ClockExample clockExample = new ClockExample();
        log.info("{}", clockExample.showRealTime());
        log.info("{}", clockExample.showTime());
    }
}
