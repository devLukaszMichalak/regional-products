package dev.lukaszmichalak.regionalproducts.voivodeship.dto;

public record VoivodeshipDto(
    Long id,
    String name,
    String code,
    String descriptionEn,
    String descriptionPl,
    String coatOfArmsFilename) {}
