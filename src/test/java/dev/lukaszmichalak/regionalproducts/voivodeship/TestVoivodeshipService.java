package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import dev.lukaszmichalak.regionalproducts.voivodeship.exception.VoivodeshipNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class TestVoivodeshipService implements VoivodeshipService {

  private static final Map<Integer, VoivodeshipDto> voivodeships = new HashMap<>();

  static {
    var v =
        new VoivodeshipDto(
            1,
            "dolnośląskie",
            "DS",
            "Dolnośląskie stands out for its exceptional variety of culinary delights. Savor the unique flavors of heather and buckwheat honeys, both reflecting the region’s diverse landscapes. The area is celebrated for artisanal cheeses like Zgorzelec and Lomnica goat cheese, traditional cured meats including Kiełbasa niemczańska and Karkonosze salceson, and distinctive baked goods such as Chleb gogołowicki and Miodowe pierniczki from Przemków.",
            "Dolnośląskie wyróżnia się wyjątkową różnorodnością kulinarnych przysmaków. Skosztuj unikalnych smaków miodów wrzosowego i gryczanego, odzwierciedlających zróżnicowane krajobrazy regionu. Region słynie z serów rzemieślniczych, takich jak ser kozi z Zgorzelca i Łomnicy, tradycyjnych wędlin, w tym kiełbasy niemczańskiej i salcesonu karkonoskiego, oraz wypieków, takich jak chleb gogołowicki i miodowe pierniczki z Przemkowa.",
            "800px-pol_wojewodztwo_dolnoslaskie_coa.svg_.png");
    voivodeships.put(1, v);
  }

  @Override
  public List<VoivodeshipDto> getVoivodeships() {
    return voivodeships.values().stream().toList();
  }

  @Override
  public VoivodeshipDto getVoivodeshipById(Integer id) {
    return Optional.ofNullable(voivodeships.get(id))
        .orElseThrow(() -> new VoivodeshipNotFoundException(id));
  }

  @Override
  public VoivodeshipDto getVoivodeshipByCode(String code) {
    return voivodeships.values().stream()
        .filter(v -> code.equals(v.code()))
        .findFirst()
        .orElseThrow(() -> new VoivodeshipNotFoundException(code));
  }
}