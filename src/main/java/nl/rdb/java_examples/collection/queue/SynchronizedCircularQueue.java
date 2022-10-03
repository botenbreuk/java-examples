package nl.rdb.java_examples.collection.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class SynchronizedCircularQueue<T> extends CircularQueue<T> {
    public SynchronizedCircularQueue() {
        super(new LinkedBlockingQueue<>());
    }

    public SynchronizedCircularQueue(int maxCapacity) {
        super(new LinkedBlockingQueue<>(), maxCapacity);
    }
}
