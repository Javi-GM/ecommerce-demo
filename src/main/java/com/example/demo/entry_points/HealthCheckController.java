package com.example.demo.entry_points;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class HealthCheckController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "{'status': 'ok'}";
    }
}
