package dev.lukaszmichalak.regionalproducts.voivodeship;

import dev.lukaszmichalak.regionalproducts.voivodeship.dto.VoivodeshipDto;
import java.time.LocalDateTime;

public class VoivodeshipStub {

  static Voivodeship ds =
      new Voivodeship(
          1L,
          "dolnośląskie",
          "DS",
          "Dolnośląskie stands out for its exceptional variety of culinary delights. Savor the unique flavors of heather and buckwheat honeys, both reflecting the region’s diverse landscapes. The area is celebrated for artisanal cheeses like Zgorzelec and Lomnica goat cheese, traditional cured meats including Kiełbasa niemczańska and Karkonosze salceson, and distinctive baked goods such as Chleb gogołowicki and Miodowe pierniczki from Przemków.",
          "Dolnośląskie wyróżnia się wyjątkową różnorodnością kulinarnych przysmaków. Skosztuj unikalnych smaków miodów wrzosowego i gryczanego, odzwierciedlających zróżnicowane krajobrazy regionu. Region słynie z serów rzemieślniczych, takich jak ser kozi z Zgorzelca i Łomnicy, tradycyjnych wędlin, w tym kiełbasy niemczańskiej i salcesonu karkonoskiego, oraz wypieków, takich jak chleb gogołowicki i miodowe pierniczki z Przemkowa.",
          "800px-pol_wojewodztwo_dolnoslaskie_coa.svg_.png",
          LocalDateTime.of(2025, 1, 1, 12, 0));

  public static VoivodeshipDto dsDto() {
    return VoivodeshipMapper.toDto(ds);
  }
}
