package nl.rdb.java_examples.string;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class StringExample {

    @Example
    public void generateExample() {
        log.info(new CodeGenerator().getCode());
    }

    @Example(name = "Unique id generator")
    public void generateUniqueId() {
        new UniqueIdGenerator().generateUID(4);
    }

    @Example
    public void stringReplace() {
        String str = "42 B.V.";
        log.info(str.replaceAll("[,. ]", "").toLowerCase());
        String str2 = "42bv";
        log.info(str2.replaceAll("[,. ]", "").toLowerCase());
    }
}
