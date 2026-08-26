package nl.rdb.java_examples.reflection.builder;

import nl.rdb.java_examples.entities.Person;

public class PersonFixtures extends AbstractBuilder<Person, PersonBuildCommand> {

    @Override
    public PersonBuildCommand base() {
        return blank();
    }
}