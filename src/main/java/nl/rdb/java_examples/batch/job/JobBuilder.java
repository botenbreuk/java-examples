package nl.rdb.java_examples.batch.job;

import java.util.LinkedList;

import nl.rdb.java_examples.batch.reader.Reader;
import nl.rdb.java_examples.batch.step.Step;

public class JobBuilder<T> {

    private final LinkedList<Step<T>> steps = new LinkedList<>();
    private final int chunkSize;
    private Reader<T> reader;
    private Boolean parallel;

    public JobBuilder(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public JobBuilder(int chunkSize, boolean parallel) {
        this.chunkSize = chunkSize;
        this.parallel = parallel;
    }

    public JobBuilder<T> reader(Reader<T> reader) {
        this.reader = reader;
        return this;
    }

    public JobBuilder<T> addStep(Step<T> step) {
        this.steps.add(step);
        return this;
    }

    public Job<T> build() {
        if (parallel == null) {
            return new Job<>(reader, steps, chunkSize);
        } else {
            return new Job<>(reader, steps, chunkSize, parallel);
        }
    }
}