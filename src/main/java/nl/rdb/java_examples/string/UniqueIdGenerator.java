package nl.rdb.java_examples.string;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UniqueIdGenerator {

    public void generateUID(int number) {
        for (int i = 0; i < number; i++) {
            log.info(UUID.randomUUID().toString());
        }
    }
}
