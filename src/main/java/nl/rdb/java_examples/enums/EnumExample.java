package nl.rdb.java_examples.enums;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class EnumExample {

    @Example
    void nameToStringExample() {
        log.info(TestEnum.HELLO.name());
        log.info("{}", Authority.CLIENTS_MANAGE);
    }

    @Example
    void nullExample() {
        TestEnum nullValue = null;
        TestEnum notNullValue = TestEnum.HELLO;

        log.info("Null value check with ==: {}", nullValue == TestEnum.HELLO);
        log.info("Not null value check with ==: {}", notNullValue == TestEnum.HELLO);
    }
}
