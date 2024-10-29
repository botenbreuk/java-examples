package nl.rdb.java_examples.batch.person_job;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.batch.step.Step;
import nl.rdb.java_examples.entities.Person;

@Slf4j
public class ShowNameStep implements Step<Person> {

    @Override
    public void execute(List<Person> values) {
        values.forEach(person -> log.info(person.getFirstname()));
    }
}
