package com.example.demo;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public final class RatePostControllerTest extends RequestTestCase {
    @Test
    void create_a_rate() throws Exception {

        JSONObject body = new JSONObject();

        body.put("brandId", 1);
        body.put("productId", 1);
        body.put("startDate", "2022-01-01");
        body.put("endDate", "2022-01-03");
        body.put("price", 2350);
        body.put("currencyCode", "EUR");

        assertRequestWithBody(
            "POST", 
            "/rates", 
            body.toString(),
            201
        );
        // "{\"brandId\":1,\"productId\":1,\"startDate\":2022-01-01,\"endDate\":2022-01-03,\"price\":2350, \"currencyCode\":EUR}",
    }
}
