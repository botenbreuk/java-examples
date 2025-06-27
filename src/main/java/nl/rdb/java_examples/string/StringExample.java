package nl.rdb.java_examples.string;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class StringExample {

    private static final Pattern PATTERN = Pattern.compile("\\{([^}]+)}");

    @Example
    void generateExample() {
        log.info(new CodeGenerator().getCode());
    }

    @Example(name = "Unique id generator")
    void generateUniqueId() {
        new UniqueIdGenerator().generateUID(4);
    }

    @Example
    void stringReplace() {
        String str = "42 B.V.";
        log.info(str.replaceAll("[,. ]", "").toLowerCase());
        String str2 = "42bv";
        log.info(str2.replaceAll("[,. ]", "").toLowerCase());
    }

    @Example
    void replace() {
        String test = "... ... \\. ..";

        log.info("{}", test.replace(".", "Test-"));
        log.info("{}", test.replaceAll("\\.", "Test-"));
    }

    @Example
    void replacePlaceHolders() {
        String urlTemplate = "http://localhost/test/{id}/test/{id2}";

        Map<String, String> params = new HashMap<>();
        params.put("id", "12345");
        params.put("id2", "user-profile");

        log.info("Original URL Template: {}", urlTemplate);
        log.info("User Variables: {}", params);

        try {
            String finalUrl = replace(urlTemplate, params);
            log.info("Final URL: {}", finalUrl);
        } catch (IllegalArgumentException e) {
            // Log the error with the exception message.
            log.error("Error replacing placeholders: {}", e.getMessage());
        }
    }

    @Example
    void replacePlaceHoldersMissingPlaceholder() {
        String urlTemplate = "http://localhost/test/{id}/test/{id2}";

        Map<String, String> params = new HashMap<>();
        params.put("id", "12345");
        params.put("id2", "user-profile");

        Map<String, String> incompleteVariables = new HashMap<>();
        incompleteVariables.put("id", "987");

        log.info("Original URL Template: {}", urlTemplate);
        log.info("Incomplete Variables: {}", incompleteVariables);

        try {
            String finalUrl = replace(urlTemplate, incompleteVariables);
            log.info("Final URL: {}", finalUrl);
        } catch (IllegalArgumentException e) {
            // It's good practice to also log the exception object itself for a full stack trace
            log.error("Error replacing placeholders: {}", e.getMessage(), e);
        }
    }

    private String replace(String template, Map<String, String> variables) {
        Matcher matcher = PATTERN.matcher(template);
        StringBuilder resultBuilder = new StringBuilder();

        while (matcher.find()) {
            String placeholderName = matcher.group(1);
            String replacement = variables.get(placeholderName);

            if (replacement == null) {
                throw new IllegalArgumentException("No value found for placeholder: %s".formatted(matcher.group(0)));
            }

            matcher.appendReplacement(resultBuilder, replacement);
        }

        matcher.appendTail(resultBuilder);
        return resultBuilder.toString();
    }
}
