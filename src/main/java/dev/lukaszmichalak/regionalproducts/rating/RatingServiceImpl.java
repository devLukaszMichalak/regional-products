package dev.lukaszmichalak.regionalproducts.rating;

import dev.lukaszmichalak.regionalproducts.gateway.command.PostRatingCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
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
  public void saveUserRating(PostRatingCommand cmd) {
    List<Rating> oldRatings = ratingRepository.findByProductId(cmd.productId());
    Long currentUserId = getCurrentUserId();

    if (hasUserRating(oldRatings, currentUserId)) {
      updateExistingRating(cmd, oldRatings, currentUserId);
    } else {
      addNewRating(cmd, oldRatings, currentUserId);
    }
  }

  private boolean hasUserRating(List<Rating> oldRatings, Long currentUserId) {
    return oldRatings.stream().anyMatch(r -> r.getUserId().equals(currentUserId));
  }

  private void updateExistingRating(
      PostRatingCommand cmd, List<Rating> oldRatings, Long currentUserId) {
    log.debug(
        "Rating already exists for product {}. The old rating will be removed.", cmd.productId());

    Long ratingSum =
        oldRatings.stream()
                .filter(r -> !r.getUserId().equals(currentUserId))
                .mapToLong(Rating::getRating)
                .sum()
            + cmd.rating();

    BigDecimal averageRating = getAverageRating(ratingSum, oldRatings.size());

    productService.updateAverageRating(cmd.productId(), averageRating);
    ratingRepository.updateRatingByUserIdAndProductId(cmd.rating(), currentUserId, cmd.productId());
  }

  private void addNewRating(PostRatingCommand cmd, List<Rating> oldRatings, Long currentUserId) {
    Long ratingSum = oldRatings.stream().mapToLong(Rating::getRating).sum() + cmd.rating();

    BigDecimal averageRating = getAverageRating(ratingSum, oldRatings.size() + 1);

    productService.updateAverageRating(cmd.productId(), averageRating);
    ratingRepository.save(new Rating(currentUserId, cmd.productId(), cmd.rating()));
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
