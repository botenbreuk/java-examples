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
    void base64StringExample() throws Exception {
        try (var out1 = new ByteArrayOutputStream();) {
            serialize("Hello world!", out1);
            log.info("Encoding 1: {}", out1);
        }

        try (var out2 = new ByteArrayOutputStream();) {
            serialize("Hello world!", out2);
            log.info("Encoding 2: {}", out2);
        }
    }

    @Example
    void base64() {
        String test = """
                -----BEGIN CERTIFICATE-----
                MIIEHzCCAwegAwIBAgIJAOGFzLmVYmLkMA0GCSqGSIb3DQEBCwUAMIGQMQswCQYD
                VQQGEwJOTDEVMBMGA1UECAwMWnVpZC1Ib2xsYW5kMRMwEQYDVQQHDApab2V0ZXJt
                ZWVyMQ4wDAYDVQQKDAU0MiBCVjEiMCAGA1UECwwZRGVwYXJ0bWVudCBvZiBXZWJz
                ZXJ2aWNlczEhMB8GA1UEAwwYNDIgQlYgU2VydmVyIENlcnRpZmljYXRlMB4XDTIw
                MDEyNzE0MjYyMFoXDTIxMDYxMDE0MjYyMFowgaQxCzAJBgNVBAYTAk5MMRUwEwYD
                VQQIEwxadWlkLUhvbGxhbmQxEzARBgNVBAcTClpvZXRlcm1lZXIxDjAMBgNVBAoT
                BTQyIEJWMSUwIwYDVQQLExxEZXBhcnRtZW50IG9mIEltcGxlbWVudGF0aW9uMRIw
                EAYDVQQDEwlsb2NhbGhvc3QxHjAcBgkqhkiG9w0BCQEWD2RldmVsb3BlckA0Mi5u
                bDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKGyvQCvcU3y+c7aTjZl
                ni7rpBTrms7oEea/krJmYoxNzMrFSNG2I8Z60jbDNI8RYH5p1Bv+DFnPm831Zsfh
                dg2two6sm2YegQj0lbwR+XhRyky5OAh/Lxn3ognhC0Y3V1IR4IWCuIrAw770F0Uh
                dSuGbe7Q/xnS9erBPrGgzYG93hbYEKijH1GGg0o3Kh7Yu3ahm1KxlujaHGX9p7Z0
                a3Ggwkz2r63tFX7U4UcGJwRojYNORRTZRMHfw8SBZ5MmrLcKaRKH27O9oVlT8659
                NWQCAm4f5lJdINzgapHsyrb0wNjI5IemI0mRMUeSt94Q/PfEdrKd1pcYLApdmFE1
                0a0CAwEAAaNmMGQwCQYDVR0TBAIwADALBgNVHQ8EBAMCBeAwSgYDVR0RBEMwQYIJ
                bG9jYWxob3N0ggU0Mi5ubIIPYml0YnVja2V0LjQyLm5sghBjb25mbHVlbmNlLjQy
                Lm5sggpqaXJhLjQyLm5sMA0GCSqGSIb3DQEBCwUAA4IBAQCv83UWm2aNzRiOQZUd
                uu/vzGV9nOw+440y4zwiGRFAUMiu/7GjVefmdyqhdF9ftCMm3IPerh6CkthfxviX
                laZZIGV/5yuABErrswAdlZ+mU96Y65zVwSZBGjfN+5YYgpeE6Yo9Z1Sy0vkLrpYm
                x4TLShWcKWBvHO/CWWMPeEUYNtc/AwM+zI+7xBR9vVfht71uD+HjNa3WbEFiA8xk
                GUmUbF+3Oxlrgzo393Pa6x9UanjwynOxKJMIQD645+6EK8G+Rn5dN0ocJuwaOqlh
                QRH1uWUzpMVp8pvTApatyWio1f2okTyMY601nkqwO9DSYYjVrL7QvNWuN75A38/o
                wYPu
                -----END CERTIFICATE-----
                """;
        String testing = "";
        try (var out = new ByteArrayOutputStream();) {
            serialize(test, out);

            log.info("Test: {}", out);

            testing = out.toString();
        } catch (Exception ex) {
            log.error("Test");
        }

        log.info("Base64: {}", testing);
        log.info("Base64 -2: {}", new String(Base64.getEncoder().encode(test.getBytes())));
    }

    @Example
    void base64MapExample() throws Exception {
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

    private void serialize(String str, OutputStream out) throws IOException {
        var byteArrayOutputStream = new ByteArrayOutputStream(1024);
        var encodingStream = Base64.getEncoder().wrap(byteArrayOutputStream);
        try (var objectOutputStream = new ObjectOutputStream(encodingStream)) {
            objectOutputStream.writeObject(str);
        }
        out.write(byteArrayOutputStream.toByteArray());
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
