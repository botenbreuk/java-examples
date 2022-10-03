package nl.rdb.java_examples.enums;

public enum Authority {

    CLIENTS_MANAGE,
    CLIENTS_READ,
    EMAIL_REPLACEMENTS_READ,
    EMAIL_SEND,
    EMAIL_TEMPLATES_MANAGE,
    EMAIL_TEMPLATES_READ,
    METADATA_MANAGE,
    METADATA_READ,
    SERVERS_MANAGE,
    SERVERS_READ,
    STATUS_MANAGE,
    STATUS_READ,
    WEBSITES_MANAGE,
    WEBSITES_READ;

    @Override
    public String toString() {
        return "hasAuthority('" + this.name().toLowerCase() + "')";
    }
}
