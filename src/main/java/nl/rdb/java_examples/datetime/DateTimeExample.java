package nl.rdb.java_examples.datetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class DateTimeExample {

    @Example
    void dateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2018, 11, 2, 12, 32, 22, 300);
        log.info(dateTime.toLocalTime().toString());
    }

    @Example
    void format() {
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
    void formatZoneOffset() {
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
    void timeUnitExample() {
        log.info("{}", TimeUnit.HOURS.toMillis(1));
    }

    @Example
    void businessDays() {
        record Test(LocalDateTime start, LocalDateTime end) {}

        final LocalDateTime now = LocalDateTime.of(2024, 11, 20, 0, 0);
        final LocalDateTime next = now.plusDays(7);

        Stream.of(new Test(now, next), new Test(LocalDateTime.now(), LocalDateTime.now().plusDays(13)))
                .map(v -> countBusinessDays(v.start, v.end).size())
                .forEach(v -> log.info("{}", v));
    }

    @Example
    void isAfterCheck() {
        LocalDateTime start = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();
        LocalDateTime end1 = start.plusHours(1);
        LocalDateTime end2 = LocalDateTime.now().plusDays(1).toLocalDate().atStartOfDay();

        log.info("Is end1 after {}", end1.isAfter(start) ? "Yes" : "No");
        log.info("Is end2 after {}", end2.isAfter(start) ? "Yes" : "No");
        log.info("Is end2 equal {}", end2.isEqual(start) ? "Yes" : "No");
    }

    private List<LocalDateTime> countBusinessDays(LocalDateTime startDate, LocalDateTime endDate) {
        // Predicate 2: Is a given date is a weekday
        Predicate<LocalDateTime> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        // Get all days between two dates
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        // Iterate over stream of all dates and check each day against any weekday or
        // holiday
        return Stream.iterate(startDate, date -> date.plusDays(1))
                .limit(daysBetween)
                .filter(isWeekend.negate())
                .toList();
    }
}
