package dev.lukaszmichalak.regionalproducts.rating;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

interface RatingRepository extends ListCrudRepository<Rating, Long> {
    
    List<Rating> findByProductId(Long productId);
    
    @Modifying
    void deleteRatingByProductIdAndUserId(Long productId, Long userId);
}
