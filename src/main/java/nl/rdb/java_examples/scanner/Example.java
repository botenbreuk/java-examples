package nl.rdb.java_examples.scanner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Example {
    String name() default "";

    boolean showClassMethod() default false;

    boolean disabled() default false;
}
