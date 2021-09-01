package org.csystem.springboot.app.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateToString implements Converter<LocalDate, String> {
    @Override
    public String convert(LocalDate localDate)
    {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
    }
}
