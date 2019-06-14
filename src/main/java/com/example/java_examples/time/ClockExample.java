package com.example.java_examples.time;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockExample {

    private final LocalDateTime reference_date_time = LocalDateTime.of(2016, 4, 1, 10, 0); //2016-04-01 at 10:00am
    private final ZoneId defaultZone = ZoneId.systemDefault();
    private final Clock fixed_clock = Clock.fixed(reference_date_time.atZone(defaultZone).toInstant(), defaultZone);
    
    public ClockExample() {
    }
    
    public LocalDateTime showTime() {
        return LocalDateTime.now(fixed_clock);
    }
    
    public LocalDateTime showRealTime() {
        return LocalDateTime.now();
    }
}
