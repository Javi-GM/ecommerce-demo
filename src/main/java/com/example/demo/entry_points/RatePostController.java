package com.example.demo.entry_points;

import java.net.URI;

import com.example.demo.application.CreateRateRequest;
import com.example.demo.application.RateCreator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
class RatePostController {

    private final RateCreator rateCreator;

    public RatePostController(RateCreator rateCreator) {
        this.rateCreator = rateCreator;
    }

    @PutMapping("rates/{id}")
    public ResponseEntity<HttpStatus> create(@PathVariable String id, @RequestBody RateDTO request) {
        rateCreator.createRate(
            new CreateRateRequest(
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

        return ResponseEntity.created(location).build();
    }
}
