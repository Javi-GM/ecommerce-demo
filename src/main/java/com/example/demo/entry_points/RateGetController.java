package com.example.demo.entry_points;

import java.util.Optional;

import com.example.demo.application.CurrencyManager;
import com.example.demo.application.RateFinder;
import com.example.demo.domain.Currency;
import com.example.demo.domain.Id;
import com.example.demo.domain.Rate;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class RateGetController {
    private final RateFinder rateFinder;
    private final CurrencyManager currencyManager;

    public RateGetController(RateFinder rateFinder, CurrencyManager currencyManager) {
        this.rateFinder = rateFinder;
        this.currencyManager = currencyManager;
    }

    @GetMapping("/rates/{id}")
    public ResponseEntity<Response> getRate(@PathVariable("id") String id) throws NotFoundException {
        //TODO implement custom exception
        Response rate = rateFinder.find(new Id(id))
                                  .map(this::rateToResponse)
                                  .orElseThrow(() -> new NotFoundException());

        return ResponseEntity.ok(rate);
    }

    private Response rateToResponse(Rate rate) {
        Optional<Currency> currency = currencyManager.findCurrencyByCurrencyCode(rate.currencyCode());

        return new Response(
            rate.id().value(),
            rate.brandId().value(),
            rate.productId().value(),
            rate.availabilityIntervalTime().getStartDate().toString(),
            rate.availabilityIntervalTime().getEndDate().toString(),
            currency.get().obtainPriceWithDecimalPlaces(rate.price().value()),
            currency.get().symbol(),
            rate.currencyCode().value()
        );
    }

    private record Response(
         String id,
         String brandId,
         String productId,
         String startDate,
         String endDate,
         double price,
         String currencySymbol,
         String currencyCode
    ) {}

}
