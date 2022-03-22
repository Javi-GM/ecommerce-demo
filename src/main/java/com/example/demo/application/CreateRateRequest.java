package com.example.demo.application;

public final record CreateRateRequest(
    String id, 
    String brandId, 
    String productId, 
    String startDate, 
    String endDate, 
    int price,
    String currencyCode
) {
}
