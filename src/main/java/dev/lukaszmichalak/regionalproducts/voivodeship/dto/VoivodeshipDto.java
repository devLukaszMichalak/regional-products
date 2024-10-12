package dev.lukaszmichalak.regionalproducts.voivodeship.dto;

public record VoivodeshipDto(
    Integer id,
    String name,
    String code,
    String descriptionEn,
    String descriptionPl,
    String coatOfArmsFilename) {}
