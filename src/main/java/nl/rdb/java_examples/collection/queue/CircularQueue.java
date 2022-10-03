package nl.rdb.java_examples.collection.queue;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import lombok.NonNull;

public class CircularQueue<T> extends AbstractQueue<T> {

    private int maxCapacity = 100;
    private final Queue<T> queue;

    public CircularQueue() {
        this.queue = new LinkedList<>();
    }

    public CircularQueue(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.queue = new LinkedList<>();
    }

    protected CircularQueue(Queue<T> queue) {
        this.queue = queue;
    }

    protected CircularQueue(Queue<T> queue, int maxCapacity) {
        this.queue = queue;
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean add(@NonNull T t) {
        while (queue.size() >= maxCapacity) {
            queue.remove();
        }

        return queue.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean offer(T t) {
        return queue.offer(t);
    }

    @Override
    public T poll() {
        return queue.poll();
    }

    @Override
    public T peek() {
        return queue.peek();
    }
}
