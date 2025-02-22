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
    return ProductMapper.toDto(wine);
  }

  public static ProductDto honeyDto() {
    return ProductMapper.toDto(honey);
  }

  public static long count = 2L;
}
