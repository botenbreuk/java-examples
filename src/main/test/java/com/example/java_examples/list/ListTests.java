package com.example.java_examples.list;

import static com.example.java_examples.Authority.CLIENTS_MANAGE;
import static com.example.java_examples.Authority.SERVERS_MANAGE;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Collections;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.example.java_examples.Authority;
import com.google.common.collect.Sets;

public class ListTests {

    @Test
    void disjoint_shouldReturnTrue() {
        Set<Authority> authoritiesList1 = Sets.newHashSet(CLIENTS_MANAGE);
        Set<Authority> authoritiesList2 = Sets.newHashSet(CLIENTS_MANAGE, SERVERS_MANAGE);

        assertFalse(Collections.disjoint(authoritiesList1, authoritiesList2));
    }
}
