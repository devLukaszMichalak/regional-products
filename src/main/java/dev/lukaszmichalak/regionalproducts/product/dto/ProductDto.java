package dev.lukaszmichalak.regionalproducts.product.dto;


import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;

import java.time.LocalDate;

public record ProductDto(
        String name,
        ProductTypeDto productType,
        VoivodeshipDto voivodeship,
        LocalDate dateOfEntry
) {
}

