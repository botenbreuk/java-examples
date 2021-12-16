package com.example.java_examples.string;

import java.util.Random;

public class CodeGenerator {

    private final Random rnd = new Random();

    public String getRandomNumberString() {
        // It will generate 6 digit random Number.
        // from 0 to 999999
        int number = this.rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }

    public String getCode() {
        String code = getRandomNumberString();
        char[] arr = code.toCharArray();

        int test = 0;
        for (char c : arr) {
            test += Integer.parseInt(Character.toString(c));
        }

        String testing = ("" + test).substring(0, 1);
        return code + testing;
    }
}
