package nl.rdb.java_examples.string;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class StringExample {

    @Example
    void generateExample() {
        log.info(new CodeGenerator().getCode());
    }

    @Example(name = "Unique id generator")
    void generateUniqueId() {
        new UniqueIdGenerator().generateUID(4);
    }

    @Example
    void stringReplace() {
        String str = "42 B.V.";
        log.info(str.replaceAll("[,. ]", "").toLowerCase());
        String str2 = "42bv";
        log.info(str2.replaceAll("[,. ]", "").toLowerCase());
    }

    @Example
    void replace() {
        String test = "... ... \\. ..";

        log.info("{}", test.replace(".", "Test-"));
        log.info("{}", test.replaceAll("\\.", "Test-"));
    }
}
