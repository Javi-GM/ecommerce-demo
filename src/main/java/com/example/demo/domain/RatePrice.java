package com.example.demo.domain;

public class RatePrice extends ValueObject<Integer> {
    private RatePrice() {
        super(null);
    }

    public RatePrice(Integer value) {
        super(value);
    }
}
