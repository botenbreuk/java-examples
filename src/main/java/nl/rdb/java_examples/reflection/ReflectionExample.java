package nl.rdb.java_examples.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.builder.simple.PersonBuilder;
import nl.rdb.java_examples.entities.Person;
import nl.rdb.java_examples.reflection.builder.PersonFixtures;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ReflectionExample {

    @Example
    void logFields() {
        Field[] fields = Person.class.getDeclaredFields();

        List<String> fieldNames = getFieldNames(fields);

        log.info("{}", fieldNames);
    }

    @Example
    void logMethods() {
        Method[] methods = Person.class.getDeclaredMethods();

        List<String> methodNames = getMethodNames(methods);

        log.info("{}", methodNames);
    }

    @Example
    void logMethodsOfInterface() {
        Method[] methods = PersonBuilder.class.getDeclaredMethods();

        List<String> methodNames = getMethodNames(methods);

        log.info("{}", methodNames);
    }

    @Example
    void initAndUseMethods() {
        PersonFixtures fixtures = new PersonFixtures();
        fixtures.base();
    }

    private List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields)
                .map(Field::getName)
                .toList();
    }

    private List<String> getMethodNames(Method[] methods) {
        return Arrays.stream(methods)
                .map(Method::getName)
                .toList();
    }

}
