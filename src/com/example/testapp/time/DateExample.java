package com.example.testapp.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateExample {

    public DateExample() {}

    public DateExample(LocalDate date) {}

    public String formatCurrentDate(String format) {
        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);

        return localDate.format(formatter);
    }

    public LocalDate addDays(LocalDate date, int days) {
        return date.plusMonths(3);
    }
}
