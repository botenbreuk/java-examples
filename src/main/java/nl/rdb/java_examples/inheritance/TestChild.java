package nl.rdb.java_examples.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestChild extends TestParent {

    @Override
    protected void world() {
        log.info("worlds of testchild");
    }
}
