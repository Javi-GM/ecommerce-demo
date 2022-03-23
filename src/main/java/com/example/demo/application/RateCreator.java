package com.example.demo.application;

import java.time.LocalDate;

import com.example.demo.domain.CurrencyCode;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateAvailabilityIntervalTime;
import com.example.demo.domain.RatePrice;
import com.example.demo.domain.RateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class RateCreator {

    private final RateRepository rateRepository;
	private CurrencyManager currencyManager;

    public RateCreator(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
        // this.currencyManager = currencyManager;
    }

    @Autowired
    public void setCurrencyManager(CurrencyManager currencyManager) {
        this.currencyManager = currencyManager;
    }

    public void createRate(CreateRateRequest request) {
        var currencyCode = new CurrencyCode(request.currencyCode());

        currencyManager
            .findCurrencyByCurrencyCode(currencyCode)
            .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

        var rate = new Rate(
            new Id(request.id()),
            new Id(request.brandId()),
            new Id(request.productId()),
            new RateAvailabilityIntervalTime(
                LocalDate.parse(request.startDate()), 
                LocalDate.parse(request.endDate()) 
            ),
            new RatePrice(request.price()),
            currencyCode
        );

        rateRepository.save(rate);
    }
}
