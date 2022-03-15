package nl.rdb.java_examples.inheritance;

public class TestChild extends TestParent {

    @Override
    protected void world() {
        System.out.println("worlds of testchild");
    }
}
