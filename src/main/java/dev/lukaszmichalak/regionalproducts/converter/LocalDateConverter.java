package dev.lukaszmichalak.regionalproducts.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter()
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public String convertToDatabaseColumn(LocalDate localDate) {
    return localDate.format(formatter);
  }

  @Override
  public LocalDate convertToEntityAttribute(String dateString) {
    return LocalDate.parse(dateString, formatter);
  }
}
