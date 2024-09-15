package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VoivodeshipMapper {
    
    VoivodeshipDto toDto(Voivodeship voivodeship) {
        
        return new VoivodeshipDto(
                voivodeship.getId(),
                voivodeship.getName(),
                voivodeship.getCode(),
                voivodeship.getDescriptionEn(),
                voivodeship.getDescriptionPl(),
                voivodeship.getCoatOfArmsFilename()
        );
    }
}
