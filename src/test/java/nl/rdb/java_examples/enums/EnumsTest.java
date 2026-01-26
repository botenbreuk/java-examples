package nl.rdb.java_examples.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EnumsTest {

    @Test
    void equalityCheck() {
        assertThrows(NullPointerException.class, () -> getEnum(true).equals(TestEnum.VALUE_ONE));

        assertThat(getEnum(false)).isEqualTo(TestEnum.VALUE_ONE);
        assertThat(getEnum(true)).isNotEqualTo(TestEnum.VALUE_ONE);
        assertThat(getEnum(false)).isEqualTo(TestEnum.VALUE_ONE);
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
