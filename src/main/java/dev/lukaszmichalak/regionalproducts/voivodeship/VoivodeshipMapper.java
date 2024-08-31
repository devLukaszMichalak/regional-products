package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import org.springframework.stereotype.Component;

@Component
class VoivodeshipMapper {
    
    VoivodeshipDto toDto(Voivodeship voivodeship) {
        return new VoivodeshipDto(voivodeship.getId(), voivodeship.getName(), voivodeship.getCoatOfArmsSvg());
    }
}
