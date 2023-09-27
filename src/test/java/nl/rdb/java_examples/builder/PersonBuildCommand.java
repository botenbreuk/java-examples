package nl.rdb.java_examples.builder;

import nl.rdb.java_examples.builder.advanced.AbstractBuildCommand;

public interface PersonBuildCommand extends AbstractBuildCommand<Person> {

    PersonBuildCommand withName(String name);

    PersonBuildCommand withAge(int age);

    default PersonBuildCommand withMessage(String message) {
        getInternalObject().setMessage(message);
        return this;
    }
}
