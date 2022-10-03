package nl.rdb.java_examples.scanner;

import java.lang.reflect.Method;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

@Slf4j
public class ExampleScanner {

    public void executeExamples() {
        Reflections reflections = new Reflections("nl.rdb.java_examples", Scanners.values());

        Set<Method> methods = reflections.getMethodsAnnotatedWith(Example.class);
        methods.forEach(method -> {
            try {
                Example annotation = method.getAnnotation(Example.class);
                if (annotation.disabled()) {
                    return;
                }

                log.info("<-- {} -->", !annotation.name().isEmpty() ? annotation.name() : method.getName());

                Class<?> clazz = method.getDeclaringClass();
                Method m = clazz.getMethod(method.getName());
                m.invoke(clazz.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                log.error("Could not make instance");
            }
        });
    }
}
