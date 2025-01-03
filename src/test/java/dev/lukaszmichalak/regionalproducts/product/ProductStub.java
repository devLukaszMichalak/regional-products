package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipStub;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductStub {

  static Product honey =
      new Product(
          1,
          "Miód wrzosowy z Borów Dolnośląskich",
          new ProductType(1, "Miody", LocalDateTime.of(2024, 1, 1, 12, 0)),
          VoivodeshipStub.ds().id(),
          LocalDate.of(2024, 1, 1),
          LocalDateTime.of(2024, 1, 1, 12, 0));

  static Product wine =
      new Product(
          2,
          "Wino śląskie",
          new ProductType(
              2, "Napoje (alkoholowe i bezalkoholowe)", LocalDateTime.of(2024, 1, 1, 12, 0)),
          VoivodeshipStub.ds().id(),
          LocalDate.of(2024, 1, 1),
          LocalDateTime.of(2024, 1, 1, 12, 0));

  public static long count = 2L;
}
