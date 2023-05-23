package nl.rdb.java_examples.filter_pattern.entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class Gebruiker {

    private String naam;
    private String email;
    private int age;
    private List<Huisdier> pets;

    public Gebruiker(String naam, String email, int age) {
        this.naam = naam;
        this.email = email;
        this.age = age;
    }

    public Gebruiker(String naam, String email, int age, List<Huisdier> pets) {
        this.naam = naam;
        this.email = email;
        this.age = age;
        this.pets = pets;
    }
}
