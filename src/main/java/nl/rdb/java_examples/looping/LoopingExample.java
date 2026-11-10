package nl.rdb.java_examples.looping;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class LoopingExample {

    @Example(disabled = true)
    void loopingExample() {
        Looping.loopie(0, 100000, obj -> log.info("{}", obj));
    }

    @Example
    void intStreamExample() {
        IntStream.of(5).forEach(i -> log.info("Class name: {} for {}", this.getClass(), i));
    }
}
