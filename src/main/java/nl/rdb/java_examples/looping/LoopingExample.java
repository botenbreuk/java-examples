package nl.rdb.java_examples.looping;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class LoopingExample {

    @Example(disabled = true)
    public void loopingExample() {
        Looping.loopie(0, 100000, obj -> log.info("{}", obj));
    }
}
