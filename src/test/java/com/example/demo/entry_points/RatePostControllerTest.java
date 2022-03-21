package com.example.demo.entry_points;

import org.json.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public final class RatePostControllerTest extends RequestTestCase {
    @Disabled
    @Test
    void create_a_rate() throws Exception {

        JSONObject body = new JSONObject();

        body.put("brandId", 1);
        body.put("productId", 1);
        body.put("startDate", "2022-01-01");
        body.put("endDate", "2022-01-03");
        body.put("price", 2350);
        body.put("currencyCode", "EUR");

        assertRequestWithBody("POST", "/rates", body.toString(), 201);
    }
}
