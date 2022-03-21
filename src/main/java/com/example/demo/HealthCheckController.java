package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HealthCheckController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "{'status': 'ok'}";
    }
}
