package com.acme.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PasswordUtilTest {

    @Test
    void hashIsDeterministic() {
        assertEquals(PasswordUtil.hash("hunter2"), PasswordUtil.hash("hunter2"));
    }

    @Test
    void hashIsNotBlank() {
        assertNotNull(PasswordUtil.hash("anything"));
    }
}
