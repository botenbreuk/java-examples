package nl.rdb.java_examples.switch_example;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class SwitchExample {

    @Example(name = "Enum switch test")
    public void returnExample() {
        Test test = Test.TEST1;
        Test test2 = Test.TEST2;
        Test test3 = Test.TEST3;

        returnTest(test);
        returnTest(test2);
        returnTest(test3);
    }

    private void returnTest(Test test) {
        switch (test) {
            case TEST1, TEST2 -> log.info("This is 1 or 2");
            case TEST3 -> log.info("This is 3");
        }
    }

    private enum Test {
        TEST1,
        TEST2,
        TEST3
    }
}