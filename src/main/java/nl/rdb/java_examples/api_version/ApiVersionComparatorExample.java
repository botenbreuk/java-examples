package nl.rdb.java_examples.api_version;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import nl.rdb.java_examples.scanner.Example;

@Slf4j
public class ApiVersionComparatorExample {

    private final List<ApiVersionConfig> versionConfigs = new ArrayList<>();

    public ApiVersionComparatorExample() {
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("0.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("4", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));
        versionConfigs.add(ApiVersionConfig.of("4.1", true));
        versionConfigs.add(ApiVersionConfig.of("3.1.1", true));
    }

    @Example(name = "API sorting")
    public void testComparator() {
        versionConfigs.stream().sorted(new ApiVersionComparator()).forEach(api -> log.info("{}", api.getVersion()));
    }

    @Example(name = "API sorting reversed", disabled = true)
    public void testComparatorReversed() {
        versionConfigs.stream().sorted(new ApiVersionComparator().reversed()).forEach(api -> log.info("{}", api.getVersion()));
    }
}
