package com.example.demo.entry_points;

public class RateDTO {
    private String brandId;
    private String productId;
    private String startDate;
    private String endDate;
    private int price;
    private String currencyCode;

    public RateDTO(String brandId, String productId, String startDate, String endDate, int price, String currencyCode) {
        this.brandId = brandId;
        this.productId = productId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Request{" +
            "brandId='" + brandId + '\'' +
            ", productId='" + productId + '\'' +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            ", price=" + price +
            ", currencyCode='" + currencyCode + '\'' +
            '}';
    }
}
