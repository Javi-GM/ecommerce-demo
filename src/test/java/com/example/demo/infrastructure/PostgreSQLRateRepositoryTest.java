package com.example.demo.infrastructure;

import com.example.demo.domain.Currency;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateAvailabilityIntervalTime;
import com.example.demo.domain.RatePrice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class PostgreSQLRateRepositoryTest {

    @Autowired
    private PostgreSQLRateRepository repository;
    
    @Test
    void save_a_valid_rate() {
        Id rateId = new Id(UUID.randomUUID().toString());

        repository.save(
           new Rate(
               rateId,
               new Id(UUID.randomUUID().toString()),
               new Id(UUID.randomUUID().toString()),
               new RateAvailabilityIntervalTime(LocalDate.now(), LocalDate.now().plusDays(1)),
               new RatePrice(1), 
               new Currency("EUR")
        ));

        Optional<Rate> rateFoundOnDB = repository.search(rateId);

        assertTrue(rateFoundOnDB.isPresent());
    }
}
