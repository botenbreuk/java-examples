package nl.rdb.java_examples.numbers;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class NumbersExample {

    @Example
    void numberStrConcat() {
        String numberConcat = 1 + 1 + 2 + "6";
        log.info(numberConcat);
    }
}
