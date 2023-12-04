package nl.rdb.java_examples.memory;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Slf4j
class MemoryLeakTest {

    @Test
    @Disabled
    void checkMemoeryLeak() {
        List<Object1> objs = new ArrayList<>();
        for (long i = 0L; i < 10000L; i++) {
            final long test = i;
            Object2 obj2 = new Object2() {{
                setNaam("Test %d".formatted(test));
            }};
            Object1 obj1 = new Object1("Naam = %d".formatted(i), obj2);
            objs.add(obj1);
            obj1 = null;
            log.info("{}", i);
        }

        objs.forEach(obj -> log.info("{}", obj.obj.naam));
    }

    public record Object1(String naam, Object2 obj) {}

    @Getter
    @Setter
    private static class Object2 {

        private String naam;
    }
}
