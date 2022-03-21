package com.example.demo.infrastructure;

import com.example.demo.domain.Rate;
import com.example.demo.domain.RateRepository;

import org.springframework.stereotype.Repository;

@Repository
public class PostgreSQLRateRepository implements RateRepository {
    @Override
    public Rate save(Rate rate) {
        // throw new UnsupportedOperationException("Not implemented yet");
        return null;
    }
}
