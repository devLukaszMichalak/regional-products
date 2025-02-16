package dev.lukaszmichalak.regionalproducts.product.dto;

import java.time.LocalDate;

public record ProductDto(
    Long id, String name, String productTypeName, LocalDate dateOfEntry, Double averageRating) {}
