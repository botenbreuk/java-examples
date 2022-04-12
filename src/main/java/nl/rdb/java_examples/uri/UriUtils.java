package nl.rdb.java_examples.uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UriUtils {

    private UriUtils() {}

    public static String encode(String url) {
        String[] parts = url.split("://");
        String protocol = parts[0];
        String domain = parts[1].split("/")[0];

        List<String> strs = new ArrayList<>(List.of(parts[1].split("/")));

        strs.remove(0);
        List<String> params = new ArrayList<>();
        if (!strs.isEmpty()) {
            String test;

            if (strs.size() > 1) {
                test = strs.remove(strs.size() - 1);
            } else {
                test = strs.remove(0);
            }

            if (!test.isEmpty()) {
                String[] queryParams = test.split("\\?");
                if (queryParams.length > 1) {
                    params = new ArrayList<>(List.of(queryParams[1].split("&")));
                }
                strs.add(queryParams[0]);
            }

            strs.forEach(str -> URLEncoder.encode(str, StandardCharsets.UTF_8));
            params.forEach(str -> URLEncoder.encode(str, StandardCharsets.UTF_8));

        }

        URI uri = null;
        try {
            String paths = strs.stream().collect(Collectors.joining("/", "/", ""));
            String query = params.stream().collect(Collectors.joining("&", "", ""));
            uri = new URI(protocol, domain, strs.isEmpty() ? null : paths, params.isEmpty() ? null : query, null);
        } catch (URISyntaxException e) {
            log.info("Something went wrong with ur: {}", url);
        }

        return uri == null ? "" : uri.toASCIIString();
    }
}
