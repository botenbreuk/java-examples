package nl.rdb.java_examples.jackson;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.entities.Address;
import nl.rdb.java_examples.entities.Person;
import nl.rdb.java_examples.entities.PersonJackson;
import nl.rdb.java_examples.jackson.deserializers.LocalDateTimeDeserializer;
import nl.rdb.java_examples.scanner.Example;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;

@Slf4j
public class JacksonExample {

    private final ObjectMapper objectMapper;

    public JacksonExample() {

        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        this.objectMapper = JsonMapper.builder()
                .enable(SerializationFeature.INDENT_OUTPUT)
                .addModule(module)
                .build();
    }

    @Example(disabled = true)
    void largeObjectToJsonSting() {

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            personList.add(new Person("First", "Last", new Address("SomeWhere 123", "1234 AB", "Amsterdam", "Nederland")));
        }

        String test = objectMapper.writeValueAsString(personList);
        log.info("JSON: {}", test);
        log.info("Length {}", test.getBytes(UTF_8).length);
    }

    @Example
    void emptyObjectToJson() {
        String personJson = objectMapper.writeValueAsString(new Person());
        log.info("JSON: {}", personJson);

        String personJsonJackson = objectMapper.writeValueAsString(new PersonJackson());
        log.info("JSON: {}", personJsonJackson);
    }

    @Example
    void dateTimeModule() {
        record Test(LocalDateTime date) {}

        Test dateTime = objectMapper.readValue("{\"date\":\"22-12-2016 00:22\"}", Test.class);
        log.info("Datetime {}", dateTime.date());
    }
}
