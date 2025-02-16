package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.util.List;

public interface VoivodeshipService {

  List<VoivodeshipDto> getVoivodeships();

  VoivodeshipDto getVoivodeshipById(Long id);

  VoivodeshipDto getVoivodeshipByCode(String code);
}
