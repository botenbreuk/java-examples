package nl.rdb.java_examples.batch.job;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.batch.reader.Reader;
import nl.rdb.java_examples.batch.step.Step;
import nl.rdb.java_examples.utils.ListUtils;
import nl.rdb.java_examples.utils.logging.TimeLogger;

import com.google.common.collect.Lists;

@Slf4j
public class Job<T> {

    private final List<Step<T>> steps;
    private final Reader<T> reader;
    private final int partitionSize;
    private final boolean parallel;
    private final JobContext jobContext;

    public Job(Reader<T> reader, List<Step<T>> steps, int partitionSize) {
        this(reader, steps, partitionSize, false);
    }

    public Job(Reader<T> reader, List<Step<T>> steps, int partitionSize, boolean parallel) {
        this.steps = steps;
        this.reader = reader;
        this.partitionSize = partitionSize;
        this.parallel = parallel;
        this.jobContext = new JobContext();
    }

    public void run() {
        List<List<T>> parts = Lists.partition(readData(), partitionSize);

        ListUtils.forEach(parts, (part, index) -> TimeLogger.logStartFinish("Page: %d of %d".formatted(index + 1, parts.size()), () -> {
            Consumer<Step<T>> stepFN = step -> {
                try {
                    step.execute(part);
                } catch (Exception e) {
                    log.error("Error during step '{}': {}", step.getClass().getSimpleName(), e.getMessage());
                }
            };

            if (this.parallel) {
                steps.parallelStream().forEach(stepFN);
            } else {
                steps.forEach(stepFN);
            }
        }));
    }

    private List<T> readData() {
        try {
            return reader.read();
        } catch (Exception ex) {
            log.error("Error during read: {}", ex.getMessage(), ex);
            return new ArrayList<>();
        }
    }
}
