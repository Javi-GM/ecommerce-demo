package com.example.demo.application;

import com.example.demo.domain.Rate;
import com.example.demo.domain.RateRepository;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

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

        Rate rateBeforeSave = new Rate(1, 1, "", "", 1, "EUR");
        Rate rateAfterSave = new Rate(1, 1, "", "", 1, "EUR");
        rateAfterSave.setId(1);

        when(rateRepository.save(rateBeforeSave)).thenReturn(rateAfterSave);

        Rate rateCreated = rateCreator.createRate(1, 1, "", "", 1, "EUR");

        verify(rateRepository, atLeastOnce()).save(rateBeforeSave);
        assertTrue(rateAfterSave.equals(rateCreated));
    }
}

