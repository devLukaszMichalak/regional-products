package dev.lukaszmichalak.regionalproducts.rating;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

interface RatingRepository extends ListCrudRepository<Rating, Long> {

  List<Rating> findByProductId(Long productId);

  @Transactional
  @Modifying
  @Query("update Rating r set r.rating = ?1 where r.userId = ?2 and r.productId = ?3")
  int updateRatingByUserIdAndProductId(Integer rating, Long userId, Long productId);
}
