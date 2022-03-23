package com.example.demo.application;

public final record UpsertRateRequest(
    String id, 
    String brandId, 
    String productId, 
    String startDate, 
    String endDate, 
    int price,
    String currencyCode
) {
}
