package com.acme.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    private final UserLookupService userLookupService;

    public DemoController(UserLookupService userLookupService) {
        this.userLookupService = userLookupService;
    }

    @GetMapping("/users")
    public List<Map<String, Object>> findUser(@RequestParam String username) {
        return userLookupService.findByUsername(username);
    }

    @GetMapping("/health")
    public String health() {
        return "ok";
    }
}
