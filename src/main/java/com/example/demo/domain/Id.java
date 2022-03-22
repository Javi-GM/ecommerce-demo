package com.example.demo.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Id implements Serializable {
    final private String value;

    //hibernate requires a no-arg constructor for reflection
    private Id() {
        this.value = null;
    }

    public Id(String value) {
        ensureIsValidUUID(value);

        this.value = value;
    }

    public String value() {
        return value;
    }

    private void ensureIsValidUUID(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Id id = (Id) o;

        return Objects.equals(value, id.value);
    }

    @Override
    public String toString() {
        return value;
    }
}
