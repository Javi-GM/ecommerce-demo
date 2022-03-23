package com.example.demo.domain;

public final class Currency {
    private final String code;
	private final String symbol;
	private final int decimalPlaces;

	public Currency(String code, String symbol, int decimalPlaces) {
        this.code = code;
        this.symbol = symbol;
        this.decimalPlaces = decimalPlaces;
    }

    public double obtainPriceWithDecimalPlaces(int price) {
        return price / Math.pow(10, decimalPlaces);
    }

    public String code() {
        return code;
    }

    public String symbol() {
        return symbol;
    }
}
