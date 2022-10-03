package nl.rdb.java_examples.interactive;

import nl.rdb.java_examples.scanner.Example;

public class InteractiveExample {

    @Example(disabled = true)
    public void shuffle() {
        Interactive interactive = new Interactive();
        interactive.shuffleSporifyList();
    }

    @Example(name = "Count user input util it reaches maximum", disabled = true)
    public void countTill() {
        Interactive interactive = new Interactive();
        interactive.countTillNumber(100);
    }
}
