package com.example.demo.entry_points;

import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerTest extends RequestTestCase {
    @Test
    void application_is_running() throws Exception{
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}
