package nl.rdb.java_examples.jackson.deserializers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.collect.Lists;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeDeserializer() {
        this(null);
    }

    protected LocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return fromString(jp.getText());
    }

    private LocalDateTime fromString(String text) {
        if (!StringUtils.isEmpty(text)) {
            List<String> formats = Lists.newArrayList(
                    "dd-MM-yyyy HH:mm", "d-MM-yyyy HH:mm", "yyyy-MM-dd HH:mm", "yyyy-MM-d HH:mm",
                    "dd-M-yyyy HH:mm", "d-M-yyyy HH:mm", "yyyy-M-dd HH:mm", "yyyy-M-d HH:mm",
                    "dd-M-yyyy HH:mm:ss", "d-M-yyyy HH:mm:ss", "yyyy-M-dd HH:mm:ss", "yyyy-M-d HH:mm:ss",
                    "dd-MM-yyyy HH:mm:ss", "d-MM-yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-d HH:mm:ss"
            );
            for (String format : formats) {
                LocalDateTime value = check(format, text);
                if (value != null) {
                    return value;
                }
            }
        }

        return null;
    }

    private LocalDateTime check(String format, String value) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        try {
            return LocalDateTime.parse(value, dtf);
        } catch (DateTimeParseException ex) {
            return null;
        }
    }
}