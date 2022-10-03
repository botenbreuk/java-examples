package nl.rdb.java_examples.datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimeExample {

    private final LocalDateTime now;

    public LocalDateTimeExample() {
        this.now = LocalDateTime.now();
    }

    public LocalDateTimeExample(LocalDateTime localDateTime) {
        this.now = localDateTime;
    }

    public String format(LocalDateTime time, String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return time.format(dtf);
    }

    public LocalDateTime parse(String time, String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDateTime.parse(time, dtf);
        } catch (Exception e) {
            log.info("Something went wrong", e);
            return null;
        }
    }

    public String getOrdinaryYearFormat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        return this.now.format(dtf);
    }

    public String getWeekBasedYearFormat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd hh:mm:ss");
        return this.now.format(dtf);
    }
}
