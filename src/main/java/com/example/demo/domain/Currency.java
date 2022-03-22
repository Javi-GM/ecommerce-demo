package com.example.demo.domain;

public final class Currency extends ValueObject<String> {
    private Currency() {
        super(null);
    }

    public Currency(String value) {
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
