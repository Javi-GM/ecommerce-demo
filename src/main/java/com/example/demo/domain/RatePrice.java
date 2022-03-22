package com.example.demo.domain;

public class RatePrice extends ValueObject<Integer> {
    private RatePrice() {
        super(null);
    }

    public RatePrice(Integer value) {
        super(value);

        testPriceIsNotUnderZero();
    }

	private void testPriceIsNotUnderZero() {
        if (value < 0) {
            throw new IllegalArgumentException("Price cannot be under zero");
        }
	}
}
