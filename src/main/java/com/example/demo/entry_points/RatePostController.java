package com.example.demo.entry_points;

import java.net.URI;

import com.example.demo.application.RateCreator;
import com.example.demo.domain.Rate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RatePostController {

    private RateCreator rateCreator;

    public RatePostController(RateCreator rateCreator) {
        this.rateCreator = rateCreator;
    }

    @PostMapping("rates")
    public ResponseEntity<Rate> create(final Request request) {
        Rate rate = rateCreator.createRate(
            request.brandId(),
            request.productId(),
            request.startDate(),
            request.endDate(),
            request.price(),
            request.currencyCode()
        );
        int rateId = rate.id();

        URI location = URI.create("/rates/" + rateId);

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(rate);
    }

    private final class Request {
        private int brandId;
        private int productId;
        private String startDate;
        private String endDate;
        private int price;
        private String currencyCode;

        public int brandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public int productId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String startDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String endDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int price() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String currencyCode() {
            return currencyCode;
        }

        public void setCurrencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
        }
    }
}
