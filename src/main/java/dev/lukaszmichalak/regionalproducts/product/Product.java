package dev.lukaszmichalak.regionalproducts.product;

import dev.lukaszmichalak.regionalproducts.common.LocalDateConverter;
import dev.lukaszmichalak.regionalproducts.common.LocalDateTimeConverter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import lombok.*;

@Getter(AccessLevel.PACKAGE)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
class Product {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_type_id", nullable = false)
  private ProductType productType;

  @Column(name = "voivodeship_id", nullable = false)
  private Long voivodeshipId;

  @Convert(converter = LocalDateConverter.class)
  @Column(name = "date_of_entry", nullable = false)
  private LocalDate dateOfEntry;
  
  @Convert(converter = LocalDateTimeConverter.class)
  @Column(name = "creation_date", nullable = false, insertable = false, updatable = false)
  private LocalDateTime creationDate;
  
  @Setter
  @Column(name = "average_rating", nullable = false)
  private BigDecimal averageRating;

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
