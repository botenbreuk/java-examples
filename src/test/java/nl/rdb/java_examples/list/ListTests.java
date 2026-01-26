package nl.rdb.java_examples.list;

import static nl.rdb.java_examples.enums.Authority.CLIENTS_MANAGE;
import static nl.rdb.java_examples.enums.Authority.EMAIL_SEND;
import static nl.rdb.java_examples.enums.Authority.SERVERS_MANAGE;
import static nl.rdb.java_examples.enums.Authority.SERVERS_READ;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Set;

import nl.rdb.java_examples.enums.Authority;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Sets;

class ListTests {

    @Test
    void disjoint_shouldReturnTrue() {
        Set<Authority> authoritiesList1 = Sets.newHashSet(CLIENTS_MANAGE);
        Set<Authority> authoritiesList2 = Sets.newHashSet(CLIENTS_MANAGE, SERVERS_MANAGE);

        assertThat(Collections.disjoint(authoritiesList1, authoritiesList2)).isFalse();
    }

    @Test
    void containsAll_shouldReturnTrue() {
        Set<Authority> authoritiesList1 = Sets.newHashSet(CLIENTS_MANAGE, SERVERS_MANAGE, EMAIL_SEND);
        Set<Authority> authoritiesList2 = Sets.newHashSet(CLIENTS_MANAGE, SERVERS_MANAGE);
        Set<Authority> authoritiesList3 = Sets.newHashSet(SERVERS_READ, SERVERS_MANAGE);

        // list 1 does not contain all items in list 3
        assertThat(authoritiesList1.containsAll(authoritiesList3)).isFalse();

        // list 1 does contain all items in list 2
        assertThat(authoritiesList1).containsAll(authoritiesList2);
    }
}
