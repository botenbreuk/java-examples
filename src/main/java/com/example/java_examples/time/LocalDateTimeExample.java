package com.example.java_examples.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {

    private LocalDateTime now;

    public LocalDateTimeExample() {
        this.now = LocalDateTime.now();
    }

    public LocalDateTimeExample(LocalDateTime localDateTime) {
        this.now = localDateTime;
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
