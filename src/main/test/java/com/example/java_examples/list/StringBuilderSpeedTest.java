package com.example.java_examples.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringBuilderSpeedTest {

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000, 10000, 50000})
    public void testSpeed_withoutBuilder(int times) {
        String str = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            str += "String";
        }
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: " + times + " test took " + (end - start) + " MilliSeconds");
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 100, 1000, 10000, 50000})
    public void testSpeed_withBuilder(int times) {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            sb.append("String");
        }
        long end = System.currentTimeMillis();
        System.out.println("DEBUG: " + times + " test took " + (end - start) + " MilliSeconds");
    }
}
