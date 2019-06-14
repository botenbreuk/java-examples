package com.example.java_examples.inheritance;

public class TestParent implements TestInterface {

    @Override
    public void helloWorld() {
        hello();
        world();
    }

    protected void world() {
        System.out.println("world");
    }

    private void hello() {
        System.out.println("Hello");
    }
}
