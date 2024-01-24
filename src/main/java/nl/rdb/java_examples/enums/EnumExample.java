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
}
