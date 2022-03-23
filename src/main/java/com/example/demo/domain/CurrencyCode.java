package com.example.demo.domain;

public final class CurrencyCode extends ValueObject<String> {
    private CurrencyCode() {
        super(null);
    }

    public CurrencyCode(String value) {
        super(value);

        testArgs();
    }

    private void testArgs() {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null");
        }

        testMaxLength();
    }

    private void testMaxLength() {
        if (value.length() > 3) {
            throw new IllegalArgumentException("Currency cannot be longer than 3 characters");
        }
    }
}
