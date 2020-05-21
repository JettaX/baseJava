package com.urise.webapp.util;

import com.urise.webapp.model.Experience;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class HtmlUtil {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String formatDates(Experience.Position position) {
        return format(position.getDateFrom()) + " - " + format(position.getDateTo());
    }

    public static String format(YearMonth date) {
        if (date == null) return "";
        return date.equals(YearMonth.now()) ? "Сейчас" : date.format(DATE_FORMATTER);
    }

    public static YearMonth parse(String date) {
        if (isEmpty(date) || "Сейчас".equals(date)) return YearMonth.now();
        YearMonth yearMonth = YearMonth.parse(date, DATE_FORMATTER);
        return YearMonth.of(yearMonth.getYear(), yearMonth.getMonth());
    }
}