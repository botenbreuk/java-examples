package nl.rdb.java_examples.looping;

import java.util.function.Consumer;

public class Looping {

    private Looping() {throw new IllegalStateException("Static class");}

    public static void loopie(int start, int times, Consumer<Object> function) {
        if (start >= times) {
            start++;
            function.accept(start);
            loopie(start, times, function);
        }
    }
}
