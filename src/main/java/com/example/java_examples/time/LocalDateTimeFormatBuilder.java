package com.example.java_examples.time;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.ListUtils;

public class LocalDateTimeFormatBuilder {

    private final List<String> days = Arrays.asList("d", "dd");
    private final List<String> years = Collections.singletonList("yyyy");
    private final List<String> yearsDays = ListUtils.union(days, years);
    private final List<String> months = Arrays.asList("MM", "M");
    private final List<String> hoursMinutes = Arrays.asList("HH:mm", "HH:mm:ss");

    public Set<String> getFormats() {
        Set<String> formats = new HashSet<>();

        for (String first : yearsDays) {
            for (String second : months) {
                yearsDays.stream()
                        .filter(third -> !third.equals(first))
                        .filter(third -> !years.contains(first) || !years.contains(third))
                        .filter(third -> !days.contains(first) || !days.contains(third))
                        .forEach(third -> {
                            String date = buildDate(first, second, third);
                            buildFormat(formats, date);
                        });
            }
        }

        return formats;
    }

    private String buildDate(String first, String second, String third) {
        return String.format("%s-%s-%s", first, second, third);
    }

    private void buildFormat(Set<String> formats, String date) {
        hoursMinutes.stream()
                .map(fourth -> String.format("%s %s", date, fourth))
                .forEach(formats::add);
    }
}
