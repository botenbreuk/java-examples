package nl.rdb.java_examples.time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LocalDateTimeExampleTest {

    @Test
    void formatDateToString() {
        LocalDateTime time = LocalDateTime.of(2020, Month.NOVEMBER, 2, 0, 0);
        LocalDateTimeExample example = new LocalDateTimeExample(time);

        String expected = "2020-11-02 12:00:00";
        String actual = example.getOrdinaryYearFormat();

        assertEquals(expected, actual);
    }

    @Test
    void parseDateToString() {
        String time = "02-11-2020 14:10";
        LocalDateTimeExample example = new LocalDateTimeExample();

        LocalDateTime expected = LocalDateTime.of(2020, Month.NOVEMBER, 2, 14, 10);
        LocalDateTime actual = example.parse(time, "dd-MM-yyyy HH:mm");

        assertEquals(expected, actual);
    }

    @Test
    void test() {
        System.out.println(MethodHandles.lookup().lookupClass());
    }

    @Nested
    class LocalDateValidation {

        LocalDate startCheck;
        LocalDate endCheck;

        @BeforeEach
        void before() {
            startCheck = null;
            endCheck = null;
        }

        @Test
        void isBefore_localDate_nowIsBetween() {
            startCheck = LocalDate.now().minusDays(12);
            endCheck = LocalDate.now().plusDays(5);

            assertTrue(inSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_nowIsBefore() {
            startCheck = LocalDate.now().plusDays(1);
            endCheck = LocalDate.now().plusDays(5);

            assertFalse(inSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_nowIsAfter() {
            startCheck = LocalDate.now().minusDays(12);
            endCheck = LocalDate.now().minusDays(1);

            assertFalse(inSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_endIsEmpty() {
            startCheck = LocalDate.now().minusDays(12);
            endCheck = null;

            assertTrue(inSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_nowIsEmpty() {
            startCheck = LocalDate.now().minusDays(12);
            endCheck = LocalDate.now().plusDays(4);

            assertTrue(inSameDateInterval(LocalDate.now(), null));
        }

        private boolean inSameDateInterval(LocalDate start1, LocalDate end1) {
            if (endCheck == null) {
                return end1 == null || !end1.isBefore(startCheck);
            }

            if (end1 == null) {
                return !start1.isAfter(endCheck);
            }

            return !end1.isBefore(startCheck) && !start1.isAfter(endCheck);
        }
    }

    @Nested
    class ZGLocalDateValidation {

        LocalDate zgStartCheck;
        LocalDate zgEndCheck;

        LocalDate gStartCheck;
        LocalDate gEndCheck;

        @BeforeEach
        void before() {
            zgStartCheck = null;
            zgEndCheck = null;

            gStartCheck = null;
            gEndCheck = null;
        }

        @Test
        void isBefore_localDate_nowIsBetween() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().plusDays(10);

            assertTrue(inZGSameDateInterval(LocalDate.now(), LocalDate.now()) && inGSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_isBetweenZg_notBetweenG() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().minusDays(10);

            assertFalse(inZGSameDateInterval(LocalDate.now(), LocalDate.now()) && inGSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_notBetweenZg_isBetweenG() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().minusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().plusDays(10);

            assertFalse(inZGSameDateInterval(LocalDate.now(), LocalDate.now()) && inGSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        @Test
        void isBefore_localDate_isBetweenZg_notBetweenG_gEindIsNull() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().minusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = null;

            assertFalse(inZGSameDateInterval(LocalDate.now(), LocalDate.now()) && inGSameDateInterval(LocalDate.now(), LocalDate.now()));
        }

        private boolean inZGSameDateInterval(LocalDate start1, LocalDate end1) {
            if (zgEndCheck == null) {
                return end1 == null || !end1.isBefore(zgStartCheck);
            }

            if (end1 == null) {
                return !start1.isAfter(zgEndCheck);
            }

            return !end1.isBefore(zgStartCheck) && !start1.isAfter(zgEndCheck);
        }

        private boolean inGSameDateInterval(LocalDate start1, LocalDate end1) {
            if (gEndCheck == null) {
                return end1 == null || !end1.isBefore(gStartCheck);
            }

            if (end1 == null) {
                return !start1.isAfter(gEndCheck);
            }

            return !end1.isBefore(gStartCheck) && !start1.isAfter(gEndCheck);
        }
    }

    @Nested
    class ZGUpdatedLocalDateValidation {

        LocalDate zgStartCheck;
        LocalDate zgEndCheck;

        LocalDate gStartCheck;
        LocalDate gEndCheck;

        @BeforeEach
        void before() {
            zgStartCheck = null;
            zgEndCheck = null;

            gStartCheck = null;
            gEndCheck = null;
        }

        @Test
        void isBefore_localDate_nowIsBetween() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().plusDays(10);

            assertTrue(inZGSameDateInterval());
        }

        @Test
        void isBefore_localDate_nowIsBetween_startIsSame() {
            zgStartCheck = LocalDate.now();
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().plusDays(10);

            assertTrue(inZGSameDateInterval());
        }

        @Test
        void isBefore_localDate_nowIsBetween_endIsSame() {
            zgStartCheck = LocalDate.now();
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now();

            assertTrue(inZGSameDateInterval());
        }

        @Test
        void isBefore_localDate_isBetweenZg_notBetweenG() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().plusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().minusDays(10);

            assertFalse(inZGSameDateInterval());
        }

        @Test
        void isBefore_localDate_notBetweenZg_isBetweenG() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().minusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = LocalDate.now().plusDays(10);

            assertFalse(inZGSameDateInterval());
        }

        @Test
        void isBefore_localDate_isBetweenZg_notBetweenG_gEindIsNull() {
            zgStartCheck = LocalDate.now().minusDays(12);
            zgEndCheck = LocalDate.now().minusDays(5);

            gStartCheck = LocalDate.now().minusDays(20);
            gEndCheck = null;

            assertFalse(inZGSameDateInterval());
        }

        private boolean inZGSameDateInterval() {
            return inGSameDateInterval(gStartCheck, gEndCheck) && inGSameDateInterval(zgStartCheck, zgEndCheck);
        }

        private boolean inGSameDateInterval(LocalDate startCheck, LocalDate endCheck) {
            var today = LocalDate.now();
            return endCheck == null ? !today.isBefore(startCheck) : !today.isBefore(startCheck) && !today.isAfter(endCheck);
        }
    }
}
