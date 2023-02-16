package nl.rdb.java_examples.counter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Counter {

    private final int start;
    private final int countUpTO;
    private int sleepTime = 1000;

    public Counter(int start, int countUpTO) {
        this.start = start >= countUpTO ? 1 : start;
        this.countUpTO = countUpTO;
    }

    public Counter setSleep(int ms) {
        this.sleepTime = ms;
        return this;
    }

    public void start() {
        try {
            for (int i = start; i <= countUpTO; i++) {
                System.out.print('\r');
                System.out.print(i);
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            log.error("Counter did not run", e);
        }
    }
}
