package com.example.demo.infrastructure;

import java.util.Optional;

import com.example.demo.domain.Currency;
import com.example.demo.domain.CurrencyCode;
import com.example.demo.domain.CurrencyRepository;

import org.springframework.stereotype.Repository;

@Repository
public class FakeCurrencyRepository implements CurrencyRepository {

	@Override
	public Optional<Currency> findCurrencyByCode(CurrencyCode id) {
        // WireMockServer wireMockServer = new WireMockServer(String host, int port);

        // manually mocking...
        // for all currency codes
        var currency = switch (id.value()) {
            case "USD"-> new Currency("USD", "$", 2);
            case "EUR"-> new Currency("EUR", "€", 2);
            case "GBP"-> new Currency("GBP", "£", 2);
            case "JPY"-> new Currency("JPY", "¥", 0);
            case "CHF"-> new Currency("CHF", "CHF", 2);

            default -> null;
        };

		return Optional.ofNullable(currency);
	}
}
