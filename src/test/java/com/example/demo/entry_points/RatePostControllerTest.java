package com.example.demo.entry_points;

import java.util.UUID;

import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public final class RatePostControllerTest extends RequestTestCase {
    @Test
    void create_a_rate() throws Exception {

        JSONObject body = new JSONObject();

        body.put("brandId", UUID.randomUUID().toString());
        body.put("productId", UUID.randomUUID().toString());
        body.put("startDate", "2022-01-01");
        body.put("endDate", "2022-01-03");
        body.put("price", 2350);
        body.put("currencyCode", "EUR");

        assertRequestWithBody(
            "PUT", 
            "/rates/" + UUID.randomUUID().toString(), 
            body.toString(), 
            201
        );
    }
}
