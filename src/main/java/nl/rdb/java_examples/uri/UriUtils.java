package nl.rdb.java_examples.uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UriUtils {

    private UriUtils() {}

    public static String encode(String url) {
        return encode(url, StandardCharsets.UTF_8);
    }

    public static String encode(String url, Charset charset) {
        String[] parts = url.split("://");
        String protocol = parts[0];
        String[] domainAndPaths = parts[1].split("/");
        String domain = domainAndPaths[0];

        List<String> pathParts = new ArrayList<>(Arrays.asList(domainAndPaths));

        // Remove the first, because this is the domain
        pathParts.remove(0);
        List<String> params = new ArrayList<>();

        // If there are paths
        if (!pathParts.isEmpty()) {
            String pathWithParams;
            int pathPartsSize = pathParts.size();

            if (pathPartsSize > 1) {
                pathWithParams = pathParts.remove(pathPartsSize - 1);
            } else {
                pathWithParams = pathParts.remove(0);
            }

            if (!pathWithParams.isEmpty()) {
                List<String> queryParams = Arrays.asList(pathWithParams.split("\\?"));
                if (queryParams.size() > 1) {
                    params = Arrays.asList(queryParams.get(1).split("&"));
                }
                pathParts.add(queryParams.get(0));
            }

            pathParts.forEach(str -> URLEncoder.encode(str, charset));
            params.forEach(str -> URLEncoder.encode(str, charset));
        }

        try {
            String paths = !pathParts.isEmpty() ? pathParts.stream().collect(Collectors.joining("/", "/", "")) : null;
            String query = !params.isEmpty() ? params.stream().collect(Collectors.joining("&", "", "")) : null;

            return new URI(protocol, domain, paths, query, null).toString();
        } catch (URISyntaxException e) {
            log.error("Something went wrong with ur: {}", url);
            return url;
        }
    }
}
