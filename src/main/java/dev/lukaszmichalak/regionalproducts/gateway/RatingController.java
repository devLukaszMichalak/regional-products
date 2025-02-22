package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.gateway.command.PostRatingCommand;
import dev.lukaszmichalak.regionalproducts.rating.RatingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class RatingController {

  private final RatingService ratingService;

  @PostMapping("/rating")
  void rating(@Valid @RequestBody PostRatingCommand cmd) {
    ratingService.saveUserRating(cmd);
  }
}
