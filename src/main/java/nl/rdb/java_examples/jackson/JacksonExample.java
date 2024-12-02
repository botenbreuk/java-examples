package nl.rdb.java_examples.jackson;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.entities.Address;
import nl.rdb.java_examples.entities.Person;
import nl.rdb.java_examples.jackson.deserializers.LocalDateTimeDeserializer;
import nl.rdb.java_examples.scanner.Example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Slf4j
public class JacksonExample {

    private final ObjectMapper objectMapper;

    public JacksonExample() {
        SimpleModule module = new JavaTimeModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        ObjectMapper objMapper = new ObjectMapper();
        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objMapper.registerModule(module);

        this.objectMapper = objMapper;
    }

    @Example(disabled = true)
    void largeObjectToJsonSting() throws Exception {

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            personList.add(new Person("First", "Last", new Address("SomeWhere 123", "1234 AB", "Amsterdam", "Nederland")));
        }

        String test = objectMapper.writeValueAsString(personList);
        log.info("JSON: {}", test);
        log.info("Length {}", test.getBytes(UTF_8).length);
    }

    @Example
    void dateTimeModule() throws Exception {
        record Test(LocalDateTime date) {}

        Test dateTime = objectMapper.readValue("{\"date\":\"22-12-2016 00:22\"}", Test.class);
        log.info("Datetime {}", dateTime.date());
    }
}
