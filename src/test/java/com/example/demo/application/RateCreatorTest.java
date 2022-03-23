package com.example.demo.application;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.UUID;

import com.example.demo.domain.CurrencyCode;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateAvailabilityIntervalTime;
import com.example.demo.domain.RatePrice;
import com.example.demo.domain.RateRepository;
import com.example.demo.infrastructure.FakeCurrencyRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RateCreatorTest {

    @Mock 
    private RateRepository rateRepository;

    @Test
    void create_a_rate() {
        RateCreator rateCreator = new RateCreator(rateRepository);
        
        //dudas
        rateCreator.setCurrencyManager(new CurrencyManager(new FakeCurrencyRepository()));

        LocalDate startDate = LocalDate.of(2021, 1, 1);
        LocalDate endDate = LocalDate.of(2021, 1, 9);

        String id = UUID.randomUUID().toString();
        String brandId = UUID.randomUUID().toString();
        String productId = UUID.randomUUID().toString();

        Rate rate = new Rate(
            new Id(id),
            new Id(brandId),
            new Id(productId),
            new RateAvailabilityIntervalTime(startDate, endDate),
            new RatePrice(1000), 
            new CurrencyCode("EUR")
        );

        CreateRateRequest createRateRequest = new CreateRateRequest(
            id,
            brandId,
            productId,
            "2021-01-01",
            "2021-01-09",
            1000, 
            "EUR"
        );

        rateCreator.createRate(createRateRequest);

        System.out.println("Rate en el test: ");
        System.out.println(rate);
        verify(rateRepository, atLeastOnce()).save(rate);
    }
}

