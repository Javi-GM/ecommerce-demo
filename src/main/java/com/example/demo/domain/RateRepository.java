package com.example.demo.domain;

import java.util.Optional;

public interface RateRepository {
    public void save(Rate rate);
    public Optional<Rate> search(Id id);
}
