package dev.lukaszmichalak.regionalproducts.rating;

import dev.lukaszmichalak.regionalproducts.gateway.command.PostRatingCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.rating.dto.RatingDto;
import dev.lukaszmichalak.regionalproducts.security.user.UserService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class RatingServiceImpl implements RatingService {

  private final RatingRepository ratingRepository;
  private final ProductService productService;
  private final UserService userService;

  @Transactional
  @Override
  public void addNewRating(PostRatingCommand cmd) {
    List<Rating> oldRatings = ratingRepository.findByProductId(cmd.productId());
    Long currentUserId = getCurrentUserId();

    if (oldRatings.stream().anyMatch(r -> r.getUserId().equals(currentUserId))) {
      log.debug(
          "Rating already exists for product {}. The old rating will be removed.", cmd.productId());

      Long oldRatingSumWithoutUserRating =
          oldRatings.stream()
              .filter(r -> !r.getUserId().equals(currentUserId))
              .mapToLong(Rating::getRating)
              .sum();

      BigDecimal averageRating =
          getAverageRating(oldRatingSumWithoutUserRating + cmd.rating(), oldRatings.size());
      productService.updateAverageRating(cmd.productId(), averageRating);

      ratingRepository.update // todo update old rating, add creation time for ratings

    } else {
      Long oldRatingSum = oldRatings.stream().mapToLong(Rating::getRating).sum();

      BigDecimal averageRating =
          getAverageRating(oldRatingSum + cmd.rating(), oldRatings.size() + 1);
      productService.updateAverageRating(cmd.productId(), averageRating);

      ratingRepository.save(new Rating(currentUserId, cmd.productId(), cmd.rating()));
    }
  }

  private Long getCurrentUserId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return userService.getUser(authentication.getName()).id();
  }

  private BigDecimal getAverageRating(Long ratingSum, int ratingCount) {

    var sum = BigDecimal.valueOf(ratingSum);
    var count = BigDecimal.valueOf(ratingCount);

    return sum.divide(count, 2, RoundingMode.HALF_UP);
  }
}
