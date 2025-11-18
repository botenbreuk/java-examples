package nl.rdb.java_examples.random;

import java.util.Random;
import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class RandomExample {

    private static final Random RANDOM = new Random();

    @Example
    void randomInt() {
        IntStream.range(0, 10).forEach(i -> log.info("index: {}: {}", i, RANDOM.nextInt(3)));
    }
}
