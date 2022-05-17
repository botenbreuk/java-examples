package nl.rdb.java_examples.api_version;

import static java.lang.Integer.valueOf;

import java.util.Comparator;

public class ApiVersionComparator implements Comparator<ApiVersionConfig> {

    /**
     * When comparing versions we take the apiVersion which has one of the following formats:
     * - major.minor.bugfix
     * - major.minor
     * - major
     * So we assume that at least a major version number will be specified.
     * Examples:
     * - 1.0.20 is higher than 1.0.2
     * - 1 is lower than 1.0
     * - 1 is lower than 1.0.0
     * - 0.1 is lower than 0.1.0
     *
     * @param v1 XmlApiVersion
     * @param v2 XmlApiVersion
     * @return int
     */
    @Override
    public int compare(ApiVersionConfig v1, ApiVersionConfig v2) {
        String[] version1 = v1.getVersion().split("\\.");
        String[] version2 = v2.getVersion().split("\\.");

        Integer major1 = valueOf(version1[0]);
        Integer major2 = valueOf(version2[0]);
        int majorResult = major1.compareTo(major2);

        return majorResult != 0 ? majorResult : compareMinorAndBugfix(version1, version2);
    }

    private int compareMinorAndBugfix(String[] version1, String[] version2) {
        if (version1.length > 1 && version2.length > 1) {
            Integer minor1 = valueOf(version1[1]);
            Integer minor2 = valueOf(version2[1]);
            int minorResult = minor1.compareTo(minor2);

            return minorResult != 0 ? minorResult : compareBugfix(version1, version2);
        } else if (version1.length == 1 && version2.length > 1) {
            return -1;
        } else if (version1.length > 1 && version2.length == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    private int compareBugfix(String[] version1, String[] version2) {
        if (version1.length > 2 && version2.length > 2) {
            Integer bugfix1 = valueOf(version1[2]);
            Integer bugfix2 = valueOf(version2[2]);
            return bugfix1.compareTo(bugfix2);
        } else if (version1.length == 2 && version2.length > 2) {
            return -1;
        } else if (version1.length > 1 && version2.length == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}