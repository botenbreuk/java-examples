package nl.rdb.java_examples.counter;

import nl.rdb.java_examples.scanner.Example;

public class CounterExample {

    @Example(disabled = true)
    public void startExample() {
        new Counter(1, 10).start();
    }

    @Example(disabled = true)
    public void startFasterExample() {
        new Counter(1, 20).setSleep(200).start();
    }
}
