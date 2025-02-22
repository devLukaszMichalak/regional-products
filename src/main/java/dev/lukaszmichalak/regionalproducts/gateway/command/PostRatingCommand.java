package dev.lukaszmichalak.regionalproducts.gateway.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PostRatingCommand(
    @NotNull @Positive Long productId, @NotNull @Min(1) @Max(5) Integer rating) {}
