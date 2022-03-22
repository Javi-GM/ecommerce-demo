package com.example.demo.entry_points;

import java.net.URI;

import com.example.demo.application.CreateRateRequest;
import com.example.demo.application.RateCreator;
import com.example.demo.domain.Rate;
import com.example.demo.utils.DateUtils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RatePostController {

    private RateCreator rateCreator;

    public RatePostController(RateCreator rateCreator) {
        this.rateCreator = rateCreator;
    }

    @PutMapping("rates/{id}")
    public ResponseEntity<HttpStatus> create(@PathVariable String id, Request request) {
        rateCreator.createRate(
            new CreateRateRequest(
                id,
                request.brandId(),
                request.productId(),
                request.startDate(),
                request.endDate(),
                request.price(),
                request.currencyCode()
            )
        );

        URI location = URI.create("/rates/" + id);

        return ResponseEntity.created(location).build();
    }

    class Request {
        private String brandId;
        private String productId;
        private String startDate;
        private String endDate;
        private int price;
        private String currencyCode;

        public String brandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String productId() {
            return productId;
        }

        public void setProductId(String productId) {
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
