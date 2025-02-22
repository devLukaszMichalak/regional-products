package dev.lukaszmichalak.regionalproducts.rating;

import dev.lukaszmichalak.regionalproducts.common.LocalDateTimeConverter;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
@NoArgsConstructor
@Table(name = "ratings")
class Rating {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "rating", nullable = false)
  private Integer rating;

  @Convert(converter = LocalDateTimeConverter.class)
  @Column(name = "creation_date", nullable = false, insertable = false, updatable = false)
  private LocalDateTime creationDate;

  Rating(Long userId, Long productId, Integer rating) {
    this.userId = userId;
    this.productId = productId;
    this.rating = rating;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Rating rating = (Rating) o;
    return id.equals(rating.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
