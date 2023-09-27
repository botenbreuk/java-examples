package nl.rdb.java_examples.enums;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EnumsTest {

    @Test
    void equalityCheck() {
        assertThrows(NullPointerException.class, () -> getEnum(true).equals(TestEnum.VALUE_ONE));
        assertTrue(getEnum(false).equals(TestEnum.VALUE_ONE));

        assertFalse(getEnum(true) == TestEnum.VALUE_ONE);
        assertTrue(getEnum(false) == TestEnum.VALUE_ONE);
    }

    private TestEnum getEnum(boolean shouldReturnNull) {
        if (shouldReturnNull) {
            return null;
        }

        return TestEnum.VALUE_ONE;
    }

    private enum TestEnum {
        VALUE_ONE,
        VALUE_TWO
    }
}
