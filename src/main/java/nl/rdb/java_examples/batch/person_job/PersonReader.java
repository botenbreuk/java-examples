package nl.rdb.java_examples.batch.person_job;

import java.util.List;

import nl.rdb.java_examples.batch.reader.Reader;
import nl.rdb.java_examples.entities.Address;
import nl.rdb.java_examples.entities.Person;

public class PersonReader implements Reader<Person> {

    @Override
    public List<Person> read() {
        Address address = new Address("Test", "Test", "Test", "Test");
        Person person1 = new Person("Test-1", "Last", null);
        Person person2 = new Person("Test-2", "Last", address);
        Person person3 = new Person("Test-3", "Last", address);
        Person person4 = new Person("Test-4", "Last", address);
        Person person5 = new Person("Test-5", "Last", address);
        return List.of(person1, person2, person3, person4, person5);
    }
}
