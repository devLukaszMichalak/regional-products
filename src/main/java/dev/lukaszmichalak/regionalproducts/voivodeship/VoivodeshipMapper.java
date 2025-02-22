package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;

class VoivodeshipMapper {

  static VoivodeshipDto toDto(Voivodeship voivodeship) {

    return new VoivodeshipDto(
        voivodeship.getId(),
        voivodeship.getName(),
        voivodeship.getCode(),
        voivodeship.getDescriptionEn(),
        voivodeship.getDescriptionPl(),
        voivodeship.getCoatOfArmsFilename());
  }
}
