package com.example.demo.domain;

import java.util.Objects;

public final class Rate {

    private Id id;
	private Id brandId;
	private Id productId;
    private RateAvailabilityIntervalTime availabilityIntervalTime;
    private RatePrice price;
	private Currency currency;

	public Rate(
        Id id,
        Id brandId, 
        Id productId, 
        RateAvailabilityIntervalTime availabilityIntervalTime, 
        RatePrice price, 
        Currency currency
    ) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.availabilityIntervalTime = availabilityIntervalTime;
        this.price = price;
        this.currency = currency;
	}

    public Id id() {
        return id;
    }

	public void setId(Id id) {
        this.id = id;
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
               Objects.equals(currency, rate.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id, 
            brandId, 
            productId, 
            availabilityIntervalTime, 
            price, 
            currency
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
               ", currency=" + currency +
               '}';
    }
}
