package com.example.demo.domain;

import java.time.LocalDate;
import java.util.Objects;

public final class RateAvailabilityIntervalTime {
    private final LocalDate startDate;
    private final LocalDate endDate;

    private RateAvailabilityIntervalTime() {
        this.startDate = null;
        this.endDate = null;
    }

    public RateAvailabilityIntervalTime(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;

        testArgs();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    private void testArgs() {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RateAvailabilityIntervalTime that = (RateAvailabilityIntervalTime) o;

        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }

    @Override
    public String toString() {
        return "RateAvailabilityIntervalTime{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
