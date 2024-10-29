package nl.rdb.java_examples.batch.person_job;

import java.util.List;

import nl.rdb.java_examples.batch.step.Step;
import nl.rdb.java_examples.entities.Person;

public class ValidatePersonStep implements Step<Person> {

    @Override
    public void execute(List<Person> values) {
        List<Person> personList = values.stream()
                .filter(person -> person.getAddress() == null)
                .toList();
        if (!personList.isEmpty()) {
            throw new RuntimeException("Validation error");
        }
    }
}
