package nl.rdb.java_examples.multi_threaded_counter;

import java.util.concurrent.atomic.AtomicBoolean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MultiThreadedCounter implements Runnable {

    private Thread worker;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final int interval;

    public MultiThreadedCounter(int sleepInterval) {
        interval = sleepInterval;
    }

    public void interrupt() {
        running.set(false);
        worker.interrupt();
    }

    public void start() {
        worker = new Thread(this);
        worker.start();
    }

    public void stop() {
        running.set(false);
    }

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                Thread.sleep(interval);
                log.info("hello");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Thread was interrupted, Failed to complete operation");
            }
            // do something here
        }
    }
}
