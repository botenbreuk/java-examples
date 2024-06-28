package nl.rdb.java_examples.if_else;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class IfElseExample {

    @Example
    void ifElseReturn() {
        if (true) {
            log.info("Return 1");
        }

        if (true) {
            if (true) {
                log.info("Test");
                return;
            }

            log.info("Return 2");
        }

        log.info("Return end");
    }

    @Example
    void ifElseReturn_withTryCatch() {
        if (true) {
            log.info("Return 1");
        }

        try {
            if (true) {
                if (true) {
                    log.info("Test");
                    return;
                }

                log.info("Return 2");
            } else {
                log.info("Test else");
            }
        } catch (Exception ex) {
            log.info("Ex {}", ex.getMessage(), ex);
        } finally {
            log.info("Finally");
        }

        log.info("Return end");
    }
}
