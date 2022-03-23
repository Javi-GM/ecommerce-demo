package com.example.demo.application;

import java.util.Optional;

import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;
import com.example.demo.domain.RateRepository;

import org.springframework.stereotype.Service;

@Service
public final class RateFinder {
    private final RateRepository rateRepository;

    public RateFinder(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Optional<Rate> find(Id id) {
        return rateRepository.search(id);
    }
}
