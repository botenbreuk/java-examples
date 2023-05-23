package nl.rdb.java_examples.api_version;

public class ApiVersionConfig {

    private String version;
    private boolean supported;

    private ApiVersionConfig() {
        super();
    }

    public static ApiVersionConfig of(String version, boolean supported) {
        ApiVersionConfig versionConfig = new ApiVersionConfig();
        versionConfig.version = version;
        versionConfig.supported = supported;
        return versionConfig;
    }

    public String getVersion() {
        return version;
    }

    public boolean isSupported() {
        return supported;
    }

    @Override
    public String toString() {
        return version;
    }
}
