package nl.rdb.java_examples.string;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.RandomBasedGenerator;
import com.fasterxml.uuid.impl.TimeBasedEpochGenerator;
import com.fasterxml.uuid.impl.TimeBasedGenerator;
import com.fasterxml.uuid.impl.UUIDUtil;

@Slf4j
public class UniqueIdGenerator {

    private static final TimeBasedGenerator V1 = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
    private static final RandomBasedGenerator V4 = Generators.randomBasedGenerator();
    private static final TimeBasedEpochGenerator V7 = Generators.timeBasedEpochGenerator();

    @Example(disabled = true)
    void generateUUID(int number) {
        for (int i = 0; i < number; i++) {
            log.info(UUID.randomUUID().toString().toUpperCase());
        }
    }

    @Example
    void generateUUIDPerVersion() {
        // V1 - FasterXML
        UUID uuid1Faster = V1.generate();

        // V4 - Java
        UUID uuid4Java = UUID.randomUUID();

        // V4 - FasterXML
        UUID uuid4Faster = V4.generate();

        // V7 - FasterXML
        UUID uuid7Faster = V7.generate();

        log.info("Version: {} of UUID: {}", getUUIDVersion(uuid1Faster), uuid1Faster.toString().toUpperCase());
        log.info("Version: {} of UUID: {}", getUUIDVersion(uuid4Java), uuid4Java.toString().toUpperCase());
        log.info("Version: {} of UUID: {}", getUUIDVersion(uuid4Faster), uuid4Faster.toString().toUpperCase());
        log.info("Version: {} of UUID: {}", getUUIDVersion(uuid7Faster), uuid7Faster.toString().toUpperCase());

        log.info("");

        log.info("Version via customMethod: {} of UUID: {}", getVersion(uuid1Faster), uuid1Faster.toString().toUpperCase());
        log.info("Version via customMethod: {} of UUID: {}", getVersion(uuid4Java), uuid4Java.toString().toUpperCase());
        log.info("Version via customMethod: {} of UUID: {}", getVersion(uuid4Faster), uuid4Faster.toString().toUpperCase());
        log.info("Version via customMethod: {} of UUID: {}", getVersion(uuid7Faster), uuid7Faster.toString().toUpperCase());
    }

    private int getUUIDVersion(UUID uuid) {
        return UUIDUtil.typeOf(uuid).raw();
    }

    private int getVersion(UUID uuid) {
        String uuidStr = uuid.toString();
        var strList = uuidStr.split("-");

        if (strList.length != 5) {
            return 0;
        }

        String versionPart = strList[2];
        return Integer.parseInt(String.valueOf(versionPart.charAt(0)));
    }
}