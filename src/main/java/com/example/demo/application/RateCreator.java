package com.example.demo.application;

import com.example.demo.domain.Rate;
import com.example.demo.domain.RateRepository;

import org.springframework.stereotype.Service;

@Service
public final class RateCreator {

    private final RateRepository rateRepository;

    public RateCreator(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate createRate(
        int brandId, 
        int productId, 
        String startDate, 
        String endDate, 
        int price, 
        String currencyCode
    ) {
        Rate rate = new Rate(
            brandId,
            productId,
            startDate,
            endDate,
            price,
            currencyCode
        );

        return rateRepository.save(rate);
    }
}
