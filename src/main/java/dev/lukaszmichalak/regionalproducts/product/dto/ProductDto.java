package dev.lukaszmichalak.regionalproducts.product.dto;


import java.time.LocalDate;

public record ProductDto(
        String name,
        String productTypeName,
        LocalDate dateOfEntry
) {
}

