package nl.rdb.java_examples.pipeline;

import nl.rdb.java_examples.pipeline.job.Job;

public class PipelineBuilder {

    private final Pipeline pipeline = new Pipeline();

    public PipelineBuilder addJob(Job job) {
        pipeline.getJobs().add(job);
        return this;
    }

    public Pipeline build() {
        return this.pipeline;
    }
}
