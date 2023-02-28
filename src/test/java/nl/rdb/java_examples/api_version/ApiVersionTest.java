package nl.rdb.java_examples.api_version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApiVersionTest {

    @Test
    @DisplayName("it should return the list in the correct order")
    void reverseOrderTest_shouldSucceed() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));

        Collections.reverse(versionConfigs);

        assertEquals("1.2.0", versionConfigs.get(0).getVersion());
        assertEquals("1.0.0", versionConfigs.get(versionConfigs.size() - 1).getVersion());
    }

    @Test
    @DisplayName("it should return the list in the incorrect order")
    void reverseOrderTest_shouldFail() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));

        Collections.reverse(versionConfigs);

        assertNotEquals("1.2.0", versionConfigs.get(0).getVersion());
        assertNotEquals("1.0.0", versionConfigs.get(versionConfigs.size() - 1).getVersion());
    }

    @Test
    @DisplayName("it should return the list in the reversed order with a comparator")
    void orderTest_withComparator_shouldSucceed() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));

        versionConfigs = versionConfigs.stream().sorted(new ApiVersionComparator()).toList();

        assertEquals("1.0.0", versionConfigs.get(0).getVersion());
        assertEquals("1.2.0", versionConfigs.get(versionConfigs.size() - 1).getVersion());
    }

    @Test
    @DisplayName("it should return the list in the reversed order with a comparator")
    void reverseOrderTest_withComparator_shouldSucceed() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("0.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("4", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));
        versionConfigs.add(ApiVersionConfig.of("4.1", true));
        versionConfigs.add(ApiVersionConfig.of("3.1.1", true));

        versionConfigs = versionConfigs.stream().sorted(new ApiVersionComparator().reversed()).toList();

        assertEquals("4.1", versionConfigs.get(0).getVersion());
        assertEquals("0.1.0", versionConfigs.get(versionConfigs.size() - 1).getVersion());
    }
}
