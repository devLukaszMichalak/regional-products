package dev.lukaszmichalak.regionalproducts.gateway.command;

public record PostRatingCommand(Long productId, Integer rating) {}
