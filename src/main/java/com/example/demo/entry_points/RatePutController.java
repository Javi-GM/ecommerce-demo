package com.example.demo.entry_points;

import java.net.URI;
import java.util.Optional;

import com.example.demo.application.UpsertRateRequest;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.application.RateFinder;
import com.example.demo.application.RateUpserter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class RatePutController {

    private final RateUpserter rateUpserter;
    private final RateFinder rateFinder;

    public RatePutController(RateUpserter rateUpserter, RateFinder rateFinder) {
        this.rateUpserter = rateUpserter;
        this.rateFinder = rateFinder;
    }

    @PutMapping("rates/{id}")
    public ResponseEntity<HttpStatus> createRate(@PathVariable String id, @RequestBody RateDTO request) {
        try {
            Optional<Rate> rateFound = rateFinder.find(new Id(id));
            rateUpserter.upsertRate(
                new UpsertRateRequest(
                    id,
                    request.getBrandId(),
                    request.getProductId(),
                    request.getStartDate(),
                    request.getEndDate(),
                    request.getPrice(),
                    request.getCurrencyCode()
                )
            );

            URI location = URI.create("/rates/" + id);

            return rateFound.isPresent() ?
                ResponseEntity.noContent().location(location).build() :
                ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
