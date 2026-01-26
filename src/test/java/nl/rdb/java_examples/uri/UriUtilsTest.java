package nl.rdb.java_examples.uri;

import static nl.rdb.java_examples.uri.UriUtils.encode;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UriUtilsTest {

    @Test
    @DisplayName("it should encode a url correctly with only a domain")
    void testEncode_withDomainOnly_shouldSucceed() {
        String url = encode("http://test.nl");
        assertThat(url).isEqualTo("http://test.nl");
    }

    @Test
    @DisplayName("it should encode a url correctly with 1 path")
    void testEncode_withDomainAndPath_shouldSucceed() {
        String url = encode("http://test.nl/test");
        assertThat(url).isEqualTo("http://test.nl/test");
    }

    @Test
    @DisplayName("it should encode a url correctly with multiple paths")
    void testEncode_withDomainAndMultiplePaths_shouldSucceed() {
        String url = encode("http://test.nl/test/testing");
        assertThat(url).isEqualTo("http://test.nl/test/testing");
    }

    @Test
    @DisplayName("it should encode a url correctly with multiple paths and 1 query param")
    void testEncode_withMultiplePathsAndQueryParam_shouldSucceed() {
        String url = encode("http://test.nl/test/testing?test=2");
        assertThat(url).isEqualTo("http://test.nl/test/testing?test=2");
    }

    @Test
    @DisplayName("it should encode a url correctly with multiple queryparams")
    void testEncode_withMultiplePathsAndMultipleQueryParams_shouldSucceed() {
        String url = encode("http://test.nl/test/testing?test=2&testing=3");
        assertThat(url).isEqualTo("http://test.nl/test/testing?test=2&testing=3");
    }

    @Test
    @DisplayName("it should encode a url correctly with path that contains spaces")
    void testEncode_withPathWithSpace_shouldSucceed() {
        String url = encode("http://test.nl/test/testing/t e s t");
        assertThat(url).isEqualTo("http://test.nl/test/testing/t%20e%20s%20t");
    }

    @Test
    @DisplayName("it should encode a url correctly with the query param that contains spaces")
    void testEncode_withQueryParamWithSpaces_shouldSucceed() {
        String url = encode("http://test.nl/test/testing?vraag=t e s t");
        assertThat(url).isEqualTo("http://test.nl/test/testing?vraag=t%20e%20s%20t");
    }

    @Test
    @DisplayName("it should encode a url correctly with the query param that contains spaces other chars")
    void testEncode_withQueryParamWithSpacesAndSpecialChars_shouldSucceed() {
        String url = encode("http://test.nl/test/testing?vraag='t e s t+something$#'");
        assertThat(url).isEqualTo("http://test.nl/test/testing?vraag='t%20e%20s%20t+something$%23'");
    }
}
