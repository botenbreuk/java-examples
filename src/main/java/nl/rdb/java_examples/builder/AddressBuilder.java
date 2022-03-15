package nl.rdb.java_examples.builder;

import nl.rdb.java_examples.entities.Address;

public class AddressBuilder {

    public AddressBuildCommand defaultAddress() {
        return new AddressBuildCommand();
    }

    public class AddressBuildCommand {

        private Address address = new Address();

        public AddressBuildCommand() {}
        public AddressBuildCommand(Address address) {
            this.address = address;
        }

        public AddressBuildCommand withStreet(String street) {
            this.address.setStreet(street);
            return this;
        }

        public AddressBuildCommand withZipcode(String zipcode) {
            this.address.setZipcode(zipcode);
            return this;
        }

        public AddressBuildCommand withCity(String city) {
            this.address.setCity(city);
            return this;
        }

        public AddressBuildCommand withCountry(String country) {
            this.address.setCountry(country);
            return this;
        }

        public Address construct() {
            return this.address;
        }
    }
}
