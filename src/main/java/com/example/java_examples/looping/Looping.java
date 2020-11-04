package com.example.java_examples.looping;

import java.util.function.Consumer;

public class Looping {

    public static void loopie(int bla, int times, Consumer<Integer> function) {
        if (bla != times) {
            bla += 1;
            function.accept(bla);
            loopie(bla, times, function);
        }
    }
}
