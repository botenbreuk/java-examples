package nl.rdb.java_examples.datetime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
    public void format() {
        String dateTime = "2023-07-05T11:05:00.000+0000";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withLocale(Locale.forLanguageTag("nl"));
        String test = dtf.format(LocalDateTime.of(2023, 7, 5, 11, 5, 0, 0).atOffset(ZoneOffset.UTC));

        if (dateTime.equals(test)) {
            log.info("There the same: {} > {}", dateTime, test);
        } else {
            log.error("There not the same: {} > {}", dateTime, test);
        }
    }

    @Example
    public void formatZoneOffset() {
        ZoneId systemZone = ZoneId.systemDefault(); // my timezone
        ZoneOffset currentOffsetForMyZone = systemZone.getRules().getOffset(LocalDateTime.now());

        String dateTime = "2023-07-05T11:05:00.000+0000";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ").withLocale(Locale.forLanguageTag("nl"));
        String test = dtf.format(LocalDateTime.of(2023, 7, 5, 11, 5, 0, 0).atOffset(currentOffsetForMyZone));

        log.info("toString(): {}", LocalDateTime.now());

        if (dateTime.equals(test)) {
            log.info("There the same: {} > {}", dateTime, test);
        } else {
            log.error("There not the same: {} > {}", dateTime, test);
        }
    }

    @Example
    public void timeUnitExample() {
        log.info("{}", TimeUnit.HOURS.toMillis(1));
    }
}
