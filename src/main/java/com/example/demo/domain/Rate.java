package com.example.demo.domain;

import java.util.Objects;

public final class Rate {

    private int id;
	private int brandId;
	private int productId;
	private String endDate;
	private String startDate;
    private int price;
	private String currencyCode;

	public Rate(int brandId, int productId, String startDate, String endDate, int price, String currencyCode) {
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currencyCode = currencyCode;
	}

    public int id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;


        return Objects.equals(id, rate.id) &&
               Objects.equals(brandId, rate.brandId) &&
               Objects.equals(productId, rate.productId) &&
               Objects.equals(startDate, rate.startDate) &&
               Objects.equals(endDate, rate.endDate) &&
               Objects.equals(price, rate.price) &&
               Objects.equals(currencyCode, rate.currencyCode);
    }

	public void setId(int id) {
        this.id = id;
	}

}
