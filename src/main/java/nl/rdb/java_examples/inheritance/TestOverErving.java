package nl.rdb.java_examples.inheritance;

public class TestOverErving {

    public void testClasses() {
        TestInterface parent = new TestParent();
        TestInterface child = new TestChild();

        parent.helloWorld();
        child.helloWorld();
    }
}
