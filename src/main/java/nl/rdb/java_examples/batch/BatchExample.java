package nl.rdb.java_examples.batch;

import nl.rdb.java_examples.batch.job.Job;
import nl.rdb.java_examples.batch.job.JobBuilder;
import nl.rdb.java_examples.batch.person_job.PersonReader;
import nl.rdb.java_examples.batch.person_job.ShowAdressStep;
import nl.rdb.java_examples.batch.person_job.ShowNameStep;
import nl.rdb.java_examples.batch.person_job.ValidatePersonStep;
import nl.rdb.java_examples.entities.Person;
import nl.rdb.java_examples.scanner.Example;

public class BatchExample {

    @Example
    void batch() {
        Job<Person> job = new JobBuilder<Person>(2)
                .reader(new PersonReader())
                .addStep(new ValidatePersonStep())
                .addStep(new ShowNameStep())
                .addStep(new ShowAdressStep())
                .build();

        job.run();
    }
}
