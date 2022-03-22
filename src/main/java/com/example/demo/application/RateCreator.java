package com.example.demo.application;

import java.time.LocalDate;

import com.example.demo.domain.Currency;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateAvailabilityIntervalTime;
import com.example.demo.domain.RatePrice;
import com.example.demo.domain.RateRepository;
import com.example.demo.utils.DateUtils;

import org.springframework.stereotype.Service;

@Service
public final class RateCreator {

    private final RateRepository rateRepository;

    public RateCreator(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public void createRate(CreateRateRequest request) {
        Rate rate = new Rate(
            new Id(request.id()),
            new Id(request.brandId()),
            new Id(request.productId()),
            new RateAvailabilityIntervalTime(
                DateUtils.fromYYYYMMDDToLocalDate(request.startDate()), 
                DateUtils.fromYYYYMMDDToLocalDate(request.endDate()) 
            ),
            new RatePrice(request.price()),
            new Currency(request.currencyCode())
        );

        System.out.println("Creating rate: ");
        System.out.println(rate);

        rateRepository.save(rate);
    }
}
