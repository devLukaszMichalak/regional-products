package dev.lukaszmichalak.regionalproducts.rating;

import jakarta.persistence.*;
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
  
  Rating(Long userId, Long productId, Integer rating) {
    this.userId = userId;
    this.productId = productId;
    this.rating = rating;
  }
}
