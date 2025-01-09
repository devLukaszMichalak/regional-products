package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.exception.VoivodeshipNotFoundException;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
@RequiredArgsConstructor
class VoivodeshipServiceImpl implements VoivodeshipService {

  private static int VOIVODESHIP_COUNT = 16;

  private final VoivodeshipRepository voivodeshipRepository;
  private final VoivodeshipMapper voivodeshipMapper;

  private final Map<Integer, VoivodeshipDto> cache = new ConcurrentHashMap<>();

  @PostConstruct
  void init() {
    VOIVODESHIP_COUNT = Long.valueOf(voivodeshipRepository.count()).intValue();
  }

  @Override
  public List<VoivodeshipDto> getVoivodeships() {

    if (cache.size() == VOIVODESHIP_COUNT) {
      return cache.values().stream().toList();
    }

    List<VoivodeshipDto> list = new ArrayList<>();
    for (Voivodeship voivodeship : voivodeshipRepository.findAll()) {
      var voivodeshipDto = voivodeshipMapper.toDto(voivodeship);
      cache.putIfAbsent(voivodeship.getId(), voivodeshipDto);
      list.add(voivodeshipDto);
    }
    return list;
  }

  @Override
  public VoivodeshipDto getVoivodeshipById(Integer id) {
    return cache.computeIfAbsent(
        id,
        key ->
            voivodeshipRepository
                .findById(key)
                .map(voivodeshipMapper::toDto)
                .orElseThrow(() -> new VoivodeshipNotFoundException(key)));
  }

  @Override
  public VoivodeshipDto getVoivodeshipByCode(String code) {
    return cache.values().stream()
        .filter(v -> v.code().equalsIgnoreCase(code))
        .findFirst()
        .orElseGet(
            () ->
                voivodeshipRepository
                    .findByCodeIgnoreCase(code)
                    .map(voivodeshipMapper::toDto)
                    .map(
                        v -> {
                          cache.put(v.id(), v);
                          return v;
                        })
                    .orElseThrow(() -> new VoivodeshipNotFoundException(code)));
  }
}
