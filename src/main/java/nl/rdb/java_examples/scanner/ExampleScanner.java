package nl.rdb.java_examples.scanner;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

@Slf4j
public class ExampleScanner {

    public void executeExamples() {
        Reflections reflections = new Reflections("nl.rdb.java_examples", Scanners.values());

        Set<Method> methods = reflections.getMethodsAnnotatedWith(Example.class);
        methods.stream()
                .filter(method -> !method.getAnnotation(Example.class).disabled())
                .sorted(Comparator.comparing(method -> method.getDeclaringClass().getSimpleName()))
                .forEach(method -> {
                    try {
                        Example annotation = method.getAnnotation(Example.class);

                        String label = determineLabel(annotation, method);
                        String topBottomBar = determineStr(label);
                        log.info(topBottomBar);
                        log.info("/--- {} ---/", label);
                        log.info(topBottomBar);

                        Class<?> clazz = method.getDeclaringClass();
                        Method m = clazz.getMethod(method.getName());
                        m.invoke(clazz.getDeclaredConstructor().newInstance());
                    } catch (Exception e) {
                        log.error("Could not make instance", e);
                    }
                });
    }

    private String determineLabel(Example annotation, Method method) {
        String name = !annotation.name().isEmpty() ? annotation.name() : method.getName();
        if (annotation.showClassMethod()) {
            return "%s::%s - %s".formatted(method.getDeclaringClass().getSimpleName(), method.getName(), name);
        } else {
            return name;
        }
    }

    private String determineStr(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/----");
        text.chars().forEach(v -> stringBuilder.append("-"));
        stringBuilder.append("----/");
        return stringBuilder.toString();
    }
}
