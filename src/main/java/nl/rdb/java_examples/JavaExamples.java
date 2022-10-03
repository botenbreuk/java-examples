package nl.rdb.java_examples;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.ExampleScanner;

@Slf4j
public class JavaExamples {

    public static void main(String[] args) {
        new ExampleScanner().executeExamples();

        //        start();

        //		Looping.loopie(0, 100000, log::info);
    }

}