package com.example.demo.domain;

import java.util.Optional;

public interface CurrencyRepository {
    Optional<Currency> findCurrencyByCode(CurrencyCode id);
}
