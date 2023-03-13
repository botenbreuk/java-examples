package nl.rdb.java_examples.architecture;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.JavaExamples;

import org.junit.jupiter.api.BeforeAll;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;

@Slf4j
public abstract class AbstractArchitectureTest {

    protected static JavaClasses importedClasses;
    protected static JavaClasses importedClassesWithTest;

    @BeforeAll
    public static void beforeAll() {
        if (importedClasses == null) {
            importedClasses = new ClassFileImporter().withImportOption(
                    new ImportOption.DoNotIncludeTests()).importPackages(JavaExamples.class.getPackageName());
        }

        if (importedClassesWithTest == null) {
            importedClassesWithTest = new ClassFileImporter().importPackages(JavaExamples.class.getPackageName());
        }
    }
}
