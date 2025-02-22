package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.common.LocalDateTimeConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_type")
class ProductType {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Convert(converter = LocalDateTimeConverter.class)
  @Column(name = "creation_date", nullable = false, insertable = false, updatable = false)
  private LocalDateTime creationDate;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductType productType = (ProductType) o;
    return Objects.equals(id, productType.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
