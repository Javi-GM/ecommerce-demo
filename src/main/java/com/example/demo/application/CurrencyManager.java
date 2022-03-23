package com.example.demo.application;

import java.util.Optional;

import com.example.demo.domain.Currency;
import com.example.demo.domain.CurrencyCode;
import com.example.demo.domain.CurrencyRepository;

import org.springframework.stereotype.Service;

@Service
public final class CurrencyManager {
    private final CurrencyRepository currencyRepository;

    public CurrencyManager(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Optional<Currency> findCurrencyByCurrencyCode(CurrencyCode currencyCode) {
        return currencyRepository.findCurrencyByCode(currencyCode);
    }
}
