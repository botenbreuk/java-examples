package com.example.java_examples.inheritance;

import java.lang.invoke.MethodHandles;

public class TestParent implements TestInterface {

    @Override
    public void helloWorld() {
        hello();
        world();
        className();
    }

    protected void world() {
        System.out.println("world");
    }

    private void hello() {
        System.out.println("Hello");
    }

    private void className() {
        System.out.println(MethodHandles.lookup().lookupClass().getComponentType());
    }
}
