package nl.rdb.java_examples.builder;

import nl.rdb.java_examples.builder.advanced.AbstractBuilder;

public class PersonFixtures extends AbstractBuilder<Person, PersonBuildCommand> {

    @Override
    public PersonBuildCommand base() {
        return blank()
                .withName("Bert")
                .withAge(21)
                .withMessage("Hello world!!");
    }

    public Person test() {
        return base()
                .withName("Jaap")
                .build();
    }
}