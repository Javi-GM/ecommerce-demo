package com.example.demo.entry_points;

import java.net.URI;

import com.example.demo.domain.Rate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RatePostController {

    @PostMapping("rates")
    public ResponseEntity<Rate> create(final Request request) {
        // return a Rate, status and set the location
        //TODO implement
        int rateId = 0;
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(URI.create("/rates/" + rateId))
                .body(null);
    }

    private final class Request {
        private int brandId;
        private int productId;
        private String startDate;
        private String endDate;
        private int price;
        private String currencyCode;

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
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
    }
}
