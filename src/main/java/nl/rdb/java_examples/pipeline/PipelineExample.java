package nl.rdb.java_examples.pipeline;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.pipeline.job.Job;
import nl.rdb.java_examples.pipeline.step.Step;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class PipelineExample {

    @Example(disabled = true)
    void pipeline() {
        Pipeline pipeline = Pipeline.builder()
                .addJob(new Job("test")
                        .addStep(new Steps.OwaspStep())
                        .addStep(new Steps.UnitTestStep()))
                .addJob(new Job("report")
                        .asyncExecution()
                        .addStep(new Steps.CoverageStep())
                        .addStep(new Steps.SonarStep()))
                .addJob(new Job("build")
                        .addStep(new Steps.CreateJarStep()))
                .build();

        pipeline.run();
    }
}

class Steps {

    private Steps() {
        throw new IllegalStateException("Utility");
    }

    @Slf4j
    public static class OwaspStep implements Step {

        @Override
        public String getName() {
            return "owasp";
        }

        @Override
        public void execute() {
            try {
                Thread.sleep(2000);
                log.info("{}", getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                log.error("Error {}", getName());
            }
        }
    }

    @Slf4j
    public static class UnitTestStep implements Step {

        @Override
        public String getName() {
            return "unit-test";
        }

        @Override
        public void execute() {
            try {
                Thread.sleep(2000);
                log.info("{}", getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                log.error("Error {}", getName());
            }
        }
    }

    @Slf4j
    public static class CoverageStep implements Step {

        @Override
        public String getName() {
            return "visualize-coverage";
        }

        @Override
        public void execute() {
            try {
                Thread.sleep(2000);
                log.info("{}", getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                log.error("Error {}", getName());
            }
        }
    }

    @Slf4j
    public static class SonarStep implements Step {

        @Override
        public String getName() {
            return "sonar";
        }

        @Override
        public void execute() {
            try {
                Thread.sleep(2000);
                log.info("{}", getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                log.error("Error {}", getName());
            }
        }
    }

    @Slf4j
    public static class CreateJarStep implements Step {

        @Override
        public String getName() {
            return "create-jar";
        }

        @Override
        public void execute() {
            try {
                Thread.sleep(2000);
                log.info("{}", getName());
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                log.error("Error {}", getName());
            }
        }
    }
}
