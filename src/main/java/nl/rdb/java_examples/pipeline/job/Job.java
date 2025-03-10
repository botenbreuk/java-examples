package nl.rdb.java_examples.pipeline.job;

import java.util.LinkedList;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.pipeline.step.Step;

@Slf4j
public class Job {

    private final LinkedList<Step> steps = new LinkedList<>();
    private final String name;

    private boolean async = false;

    public Job(String name) {
        this.name = name;
    }

    public Job addStep(Step step) {
        this.steps.add(step);
        return this;
    }

    public Job asyncExecution() {
        this.async = true;
        return this;
    }

    public void execute() {
        log.info("Running: {}", this.name);

        Stream<Step> stream = async ? steps.parallelStream() : steps.stream();
        stream.forEach(step -> {
            try {
                step.execute();
            } catch (Exception ex) {
                log.info("Step '{}' error: {}", this.name, ex.getMessage(), ex);
            }
        });
    }
}
