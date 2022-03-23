package com.example.demo.domain;

import java.util.Objects;

public final class Rate {

    private Id id;
	private Id brandId;
	private Id productId;
    private RateAvailabilityIntervalTime availabilityIntervalTime;
    private RatePrice price;
	private CurrencyCode currencyCode;

    private Rate() {}

	public Rate(
        Id id,
        Id brandId, 
        Id productId, 
        RateAvailabilityIntervalTime availabilityIntervalTime, 
        RatePrice price, 
        CurrencyCode currencyCode
    ) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.availabilityIntervalTime = availabilityIntervalTime;
        this.price = price;
        this.currencyCode = currencyCode;
	}

    public Id id() {
        return id;
    }

	public void setId(Id id) {
        this.id = id;
	}

    public CurrencyCode currencyCode() {
        return currencyCode;
    }

    public Id brandId() {
        return brandId;
    }

    public Id productId() {
        return productId;
    }

    public RateAvailabilityIntervalTime availabilityIntervalTime() {
        return availabilityIntervalTime;
    }

    public RatePrice price() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rate rate = (Rate) o;

        return Objects.equals(id, rate.id) &&
               Objects.equals(brandId, rate.brandId) &&
               Objects.equals(productId, rate.productId) &&
               Objects.equals(availabilityIntervalTime, rate.availabilityIntervalTime) &&
               Objects.equals(price, rate.price) &&
               Objects.equals(currencyCode, rate.currencyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            brandId, 
            productId, 
            availabilityIntervalTime, 
            price, 
            currencyCode
        );
    }

    @Override
    public String toString() {
        return "Rate{" +
               "id=" + id +
               ", brandId=" + brandId +
               ", productId=" + productId +
               ", availabilityIntervalTime=" + availabilityIntervalTime +
               ", price=" + price +
               ", currency=" + currencyCode +
               '}';
    }
}
