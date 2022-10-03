package nl.rdb.java_examples.clazz;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.pokemon.pokemon_kinds.Charmander;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ClassExamples {

    @Example
    public void classNameStringExample() {
        log.info(Charmander.class.getName());
        log.info(Charmander.class.getSimpleName());
    }
}
