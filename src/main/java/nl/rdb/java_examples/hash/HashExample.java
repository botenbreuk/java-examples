package nl.rdb.java_examples.hash;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class HashExample {

    @Example
    void hashValueDifferentOrderNotTheSame() {
        log.info("appel test: {}", "appel test".hashCode());
        log.info("test apple: {}", "test apple".hashCode());
    }
}
