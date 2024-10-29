package nl.rdb.java_examples.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {

    private String street;
    private String zipcode;
    private String city;
    private String country;

    public Address() {}

    public Address(String street, String zipcode, String city, String country) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;
    }

    public String geFullAddress() {
        return """
                
                %s
                %s, %s
                %s""".formatted(this.street, this.zipcode, this.city, this.country);
    }
}
