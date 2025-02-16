package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.exception.VoivodeshipNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class TestVoivodeshipService implements VoivodeshipService {

  private static final Map<Long, VoivodeshipDto> voivodeships = new HashMap<>();

  static {
    voivodeships.put(1L, VoivodeshipStub.ds());
  }

  @Override
  public List<VoivodeshipDto> getVoivodeships() {
    return voivodeships.values().stream().toList();
  }

  @Override
  public VoivodeshipDto getVoivodeshipById(Long id) {
    return Optional.ofNullable(voivodeships.get(id))
        .orElseThrow(() -> new VoivodeshipNotFoundException(id));
  }

  @Override
  public VoivodeshipDto getVoivodeshipByCode(String code) {
    return voivodeships.values().stream()
        .filter(v -> code.equalsIgnoreCase(v.code()))
        .findFirst()
        .orElseThrow(() -> new VoivodeshipNotFoundException(code));
  }
}
