package nl.rdb.java_examples.utils;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class Time {
    private static Clock clock = Clock.systemDefaultZone();
    private static final TimeZone REAL_TIME_ZONE = TimeZone.getDefault();

    public static LocalDate currentDate() {
        return LocalDate.now(getClock());
    }

    public static LocalTime currentTime() {
        return LocalTime.now(getClock());
    }

    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now(getClock());
    }

    public static OffsetDateTime currentOffsetDateTime() {
        return OffsetDateTime.now(getClock());
    }

    public static ZonedDateTime currentZonedDateTime() {
        return ZonedDateTime.now(getClock());
    }

    public static Instant currentInstant() {
        return Instant.now(getClock());
    }

    public static long currentTimeMillis() {
        return currentInstant().toEpochMilli();
    }

    public static void useMockTime(LocalDateTime dateTime, ZoneId testZoneId) {
        Instant instant = dateTime.atZone(testZoneId).toInstant();
        clock = Clock.fixed(instant, testZoneId);
        TimeZone.setDefault(TimeZone.getTimeZone(testZoneId));
    }

    public static void useSystemDefaultZoneClock() {
        TimeZone.setDefault(REAL_TIME_ZONE);
        clock = Clock.systemDefaultZone();
    }

    private static Clock getClock() {
        return clock;
    }
}