package com.codegym.formatter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
@Component
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    private DateTimeFormatter dateTimeFormatter;
    private String datetimePattern;

    public LocalDateTimeFormatter(String datetimePattern) {
        this.datetimePattern = datetimePattern;
    }

    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text,DateTimeFormatter.ofPattern(datetimePattern));
    }

    @Override
    public String print(LocalDateTime dateTime, Locale locale) {
        return dateTime.format(dateTimeFormatter);
    }
}
