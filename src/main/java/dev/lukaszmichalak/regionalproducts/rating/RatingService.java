package dev.lukaszmichalak.regionalproducts.rating;

import dev.lukaszmichalak.regionalproducts.gateway.command.PostRatingCommand;

public interface RatingService {

  void saveUserRating(PostRatingCommand cmd);
}
