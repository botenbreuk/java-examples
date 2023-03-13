package nl.rdb.java_examples.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import nl.rdb.java_examples.utils.Time;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JavaTimeArchUnitTest extends AbstractArchitectureTest {

    @Nested
    @Disabled
    class LocalDateTimeUsageTest {

        @Test
        void ensureUsageTimeDateTimeNow() {
            noClasses()
                    .should().callMethod(LocalDateTime.class, "now")
                    .because("Use Time.dateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeDateTimeNowWIthClock() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(LocalDateTime.class, "now", Clock.class)
                    .because("Use Time.dateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class LocalDateUsageTest {

        @Test
        void ensureUsageTimeDateNow() {
            noClasses()
                    .should().callMethod(LocalDate.class, "now")
                    .because("Use Time.dateNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeDateNowWithClock() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(LocalDate.class, "now", Clock.class)
                    .because("Use Time.dateNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class LocalTimeUsageTest {

        @Test
        void ensureUsageTimeTimeNow() {
            noClasses()
                    .should().callMethod(LocalTime.class, "now")
                    .because("Use Time.timeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeTimeNowWithClock() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(LocalTime.class, "now", Clock.class)
                    .because("Use Time.timeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class OffsetDateTimeUsageTest {

        @Test
        void ensureUsageTimeOffsetDateTimeNow() {
            noClasses()
                    .should().callMethod(OffsetDateTime.class, "now")
                    .because("Use Time.offsetDateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeOffsetDateTimeNowWithClock() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(OffsetDateTime.class, "now", Clock.class)
                    .because("Use Time.offsetDateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class ZonedDateTimeUsageTest {

        @Test
        void ensureUsageTimeZonedDateTimeNow() {
            noClasses()
                    .should().callMethod(ZonedDateTime.class, "now")
                    .because("Use Time.zonedDateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeZonedDateTimeNowWithClock() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(ZonedDateTime.class, "now", Clock.class)
                    .because("Use Time.zonedDateTimeNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class InstantUsageTest {

        @Test
        void ensureUsageTimeInstantNowWithClock() {
            noClasses()
                    .should().callMethod(Instant.class, "now")
                    .because("Use Time.instantNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }

        @Test
        void ensureUsageTimeInstantNow() {
            noClasses()
                    .that()
                    .doNotBelongToAnyOf(Time.class)
                    .should().callMethod(Instant.class, "now", Clock.class)
                    .because("Use Time.instantNow methods instead of as it gives opportunity of mocking time in tests")
                    .check(importedClassesWithTest);
        }
    }

    @Nested
    @Disabled
    class MockTimeUsageTest {

        @Test
        void ensureUsageTimeUseMockTime() {
            noClasses()
                    .should().callMethod(Time.class, "mockTime", LocalDateTime.class, ZoneId.class)
                    .because("Method Time.mockTime designed only for test purpose and can be used only in the tests")
                    .check(importedClasses);
        }

        @Test
        void ensureUsageTimeUseMockTimeWithoutZoneId() {
            noClasses()
                    .should().callMethod(Time.class, "mockTime", LocalDateTime.class)
                    .because("Method Time.mockTime designed only for test purpose and can be used only in the tests")
                    .check(importedClasses);
        }
    }
}