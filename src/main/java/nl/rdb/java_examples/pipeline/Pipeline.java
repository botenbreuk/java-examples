package nl.rdb.java_examples.pipeline;

import java.util.LinkedList;

import lombok.Getter;
import nl.rdb.java_examples.pipeline.job.Job;

@Getter
public class Pipeline {

    private LinkedList<Job> jobs = new LinkedList<>();

    public static PipelineBuilder builder() {
        return new PipelineBuilder();
    }

    public void run() {
        jobs.forEach(Job::execute);
    }
}
