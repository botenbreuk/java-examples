package nl.rdb.java_examples.reflection.builder;

import nl.rdb.java_examples.builder.simple.PersonBuilder;
import nl.rdb.java_examples.entities.Person;

public interface PersonBuildCommand extends AbstractBuildCommand<Person> {

    PersonBuilder withFirstname(String firstname);

    PersonBuilder withLastname(String lastname);

    PersonBuilder withAddress(String address);
}