package nl.rdb.java_examples.encoding_decoding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class Base64Example {

    @Example
    void base64Example() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("Long", 1L);
        map.put("String", "StringValue");

        String test;
        try (var out = new ByteArrayOutputStream();) {
            serialize(map, out);

            log.info("Test: {}", out);

            test = out.toString();
        }

        try (var in = new ByteArrayInputStream(test.getBytes())) {
            Map<String, Object> map2 = deserialize(in);
            log.info("Testing: {}", map2.get("String"));
        }
    }

    /**
     * Method from org.springframework.batch.core.repository.dao.DefaultExecutionContextSerializer
     *
     * @param context
     * @param out
     * @throws IOException
     */
    private void serialize(Map<String, Object> context, OutputStream out) throws IOException {
        for (Object value : context.values()) {
            if (!(value instanceof Serializable)) {
                throw new IllegalArgumentException(
                        "Value: [" + value + "] must be serializable. " + "Object of class: ["
                                + value.getClass().getName() + "] must be an instance of " + Serializable.class);
            }
        }
        var byteArrayOutputStream = new ByteArrayOutputStream(1024);
        var encodingStream = Base64.getEncoder().wrap(byteArrayOutputStream);
        try (var objectOutputStream = new ObjectOutputStream(encodingStream)) {
            objectOutputStream.writeObject(context);
        }
        out.write(byteArrayOutputStream.toByteArray());
    }

    /**
     * Method from org.springframework.batch.core.repository.dao.DefaultExecutionContextSerializer
     *
     * @param inputStream
     * @return a map
     */
    private Map<String, Object> deserialize(InputStream inputStream) {
        var decodingStream = Base64.getDecoder().wrap(inputStream);
        try {
            var objectInputStream = new ObjectInputStream(decodingStream);
            return (Map<String, Object>) objectInputStream.readObject();
        } catch (IOException ex) {
            throw new IllegalArgumentException("Failed to deserialize object", ex);
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException("Failed to deserialize object type", ex);
        }
    }
}
