package com.example.testapp.overerving;

public class TestOverErving {

    public void testClasses() {
        TestInterface parent = new TestParent();
        TestInterface child = new TestChild();

        parent.helloWorld();
        child.helloWorld();
    }
}
