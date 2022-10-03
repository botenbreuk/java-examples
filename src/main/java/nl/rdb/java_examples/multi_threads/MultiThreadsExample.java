package nl.rdb.java_examples.multi_threads;

import java.util.Queue;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.collection.queue.CircularQueue;
import nl.rdb.java_examples.collection.queue.SynchronizedCircularQueue;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class MultiThreadsExample {

    static final int MAX_IN_QUEUE = 25;
    static Queue<String> circularQueue = new CircularQueue<>(10);
    static Queue<String> queue = new SynchronizedCircularQueue<>(10);

    @Example(disabled = true)
    public void queueMultiThreads() {
        log.info("Now starting Queue logic");

        for (int i = 0; i < MAX_IN_QUEUE; i++) {
            circularQueue.add("String number: %d".formatted(i + 1));
            log.info("{}: position: {}", circularQueue.peek(), i + 1);
        }

        circularQueue.forEach(i -> log.info("Item non sync: {}", i));

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < MAX_IN_QUEUE; i++) {
                queue.add("Thread 1: String number: %d".formatted(i + 1));
                log.info("{}: position: {}", queue.peek(), i + 1);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < MAX_IN_QUEUE; i++) {
                queue.add("Thread 2: String number: %d".formatted(i + 1));
                log.info("{}: position: {}", queue.peek(), i + 1);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            log.error("Error in threads", e);
        } finally {
            queue.forEach(i -> log.info("Item: {}", i));
        }
    }
}
