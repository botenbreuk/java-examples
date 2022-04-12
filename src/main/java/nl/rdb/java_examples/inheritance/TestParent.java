package nl.rdb.java_examples.inheritance;

import java.lang.invoke.MethodHandles;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestParent implements TestInterface {

    @Override
    public void helloWorld() {
        hello();
        world();
        className();
    }

    protected void world() {
        log.info("world");
    }

    private void hello() {
        log.info("Hello");
    }

    private void className() {
        log.info("{}", MethodHandles.lookup().lookupClass().getComponentType());
    }
}
