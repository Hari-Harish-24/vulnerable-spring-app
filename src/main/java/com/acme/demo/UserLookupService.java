package com.acme.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserLookupService {

    private final JdbcTemplate jdbcTemplate;

    public UserLookupService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SEEDED-ISSUE: C1 - SQL built by string concatenation from unvalidated input.
    public List<Map<String, Object>> findByUsername(String username) {
        String sql = "select * from users where username = '" + username + "'";
        return jdbcTemplate.queryForList(sql);
    }
}
