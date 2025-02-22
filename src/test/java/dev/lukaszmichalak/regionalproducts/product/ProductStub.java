package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.product.dto.ProductDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductStub {

  static Product honey =
      new Product(
          1L,
          "Miód wrzosowy z Borów Dolnośląskich",
          new ProductType(1L, "Miody", LocalDateTime.of(2024, 1, 1, 12, 0)),
          VoivodeshipStub.dsDto().id(),
          LocalDate.of(2024, 1, 1),
          LocalDateTime.of(2024, 1, 1, 12, 0),
          BigDecimal.valueOf(2));

  static Product wine =
      new Product(
          2L,
          "Wino śląskie",
          new ProductType(
              2L, "Napoje (alkoholowe i bezalkoholowe)", LocalDateTime.of(2024, 1, 1, 12, 0)),
          VoivodeshipStub.dsDto().id(),
          LocalDate.of(2024, 1, 1),
          LocalDateTime.of(2024, 1, 1, 12, 0),
          BigDecimal.valueOf(4));

  public static ProductDto wineDto() {
    return new ProductDto(
        wine.getId(),
        wine.getName(),
        wine.getProductType().getName(),
        wine.getDateOfEntry(),
        wine.getAverageRating().doubleValue());
  }

  public static ProductDto honeyDto() {
    return new ProductDto(
        honey.getId(),
        honey.getName(),
        honey.getProductType().getName(),
        honey.getDateOfEntry(),
        honey.getAverageRating().doubleValue());
  }

  public static long count = 2L;
}
