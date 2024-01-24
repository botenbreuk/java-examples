package nl.rdb.java_examples.datetime;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class DateTimeBetweenExample {

    @Example
    void isTocayBetween() {
        boolean isBetween = isTodayBetweenCheck(LocalDateTime.now(), LocalDateTime.now());
        log.info("{}", isBetween ? "Ja" : "Nee");
    }

    @Example
    void isNotBetween() {
        boolean notBetween = !isTodayBetweenCheck(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2));
        log.info("{}", notBetween ? "Ja" : "Nee");
    }

    private boolean isTodayBetweenCheck(LocalDateTime startCheck, LocalDateTime endCheck) {
        LocalDateTime today = LocalDateTime.now().withNano(0);
        return endCheck == null ? !today.isBefore(startCheck) : !(today.isBefore(startCheck) || today.isAfter(endCheck));
    }
}
