package nl.rdb.java_examples.api_version;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(versionConfigs.getFirst().getVersion()).isEqualTo("1.2.0");
        assertThat(versionConfigs.getLast().getVersion()).isEqualTo("1.0.0");
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

        assertThat(versionConfigs.getFirst().getVersion()).isNotEqualTo("1.2.0");
        assertThat(versionConfigs.getLast().getVersion()).isNotEqualTo("1.0.0");
    }

    @Test
    @DisplayName("it should return the list in the reversed order with a comparator")
    void orderTest_withComparator_shouldSucceed() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("10.1", true));
        versionConfigs.add(ApiVersionConfig.of("0.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("2.1.2", true));
        versionConfigs.add(ApiVersionConfig.of("4", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));
        versionConfigs.add(ApiVersionConfig.of("21", true));
        versionConfigs.add(ApiVersionConfig.of("4.1", true));
        versionConfigs.add(ApiVersionConfig.of("3.1.1", true));

        versionConfigs = versionConfigs.stream().sorted(new ApiVersionComparator()).toList();

        assertThat(versionConfigs.getFirst().getVersion()).isEqualTo("0.1.0");
        assertThat(versionConfigs.getLast().getVersion()).isEqualTo("21");
    }

    @Test
    @DisplayName("it should return the list in the reversed order with a comparator")
    void reverseOrderTest_withComparator_shouldSucceed() {
        List<ApiVersionConfig> versionConfigs = new ArrayList<>();
        versionConfigs.add(ApiVersionConfig.of("1.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.0.0", true));
        versionConfigs.add(ApiVersionConfig.of("10.1", true));
        versionConfigs.add(ApiVersionConfig.of("0.1.0", true));
        versionConfigs.add(ApiVersionConfig.of("1.2.0", true));
        versionConfigs.add(ApiVersionConfig.of("2.1.2", true));
        versionConfigs.add(ApiVersionConfig.of("4", true));
        versionConfigs.add(ApiVersionConfig.of("1.1.1", true));
        versionConfigs.add(ApiVersionConfig.of("21", true));
        versionConfigs.add(ApiVersionConfig.of("4.1", true));
        versionConfigs.add(ApiVersionConfig.of("3.1.1", true));

        versionConfigs = versionConfigs.stream().sorted(new ApiVersionComparator().reversed()).toList();

        assertThat(versionConfigs.getFirst().getVersion()).isEqualTo("21");
        assertThat(versionConfigs.getLast().getVersion()).isEqualTo("0.1.0");
    }
}
