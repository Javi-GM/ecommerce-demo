package com.example.demo.utils;

import java.time.LocalDate;

public class DateUtils {
    public static LocalDate fromYYYYMMDDToLocalDate(String yyyyMMdd) {
        return LocalDate.of(Integer.parseInt(yyyyMMdd.substring(0, 4)),
                Integer.parseInt(yyyyMMdd.substring(5, 7)),
                Integer.parseInt(yyyyMMdd.substring(8)));
    }
}
