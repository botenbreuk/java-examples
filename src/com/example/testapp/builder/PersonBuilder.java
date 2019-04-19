package com.example.testapp.builder;

import com.example.testapp.entities.Address;
import com.example.testapp.entities.Person;

public class PersonBuilder {

    private AddressBuilder addressBuilder = new AddressBuilder();

    public PersonBuildCommand person() {
        return new PersonBuildCommand();
    }

    public PersonBuildCommand person(Person person) {
        return new PersonBuildCommand(person);
    }

    public PersonBuildCommand defaultPerson() {
        return person()
                .withFirstname("First")
                .withLastname("Lastname");
    }

    public PersonBuildCommand personWithAddress() {
        return defaultPerson()
                .withAddress(addressBuilder.defaultAddress().construct());
    }

    public class PersonBuildCommand {

        private Person person = new Person();

        public PersonBuildCommand() {}
        public PersonBuildCommand(Person person) {
            this.person = person;
        }

        public PersonBuildCommand withFirstname(String firstname) {
            this.person.setFirstname(firstname);
            return this;
        }

        public PersonBuildCommand withLastname(String lastname) {
            this.person.setLastname(lastname);
            return this;
        }

        public PersonBuildCommand withAddress(Address address) {
            this.person.setAddress(address);
            return this;
        }

        public Person construct() {
            return this.person;
        }
    }
}
