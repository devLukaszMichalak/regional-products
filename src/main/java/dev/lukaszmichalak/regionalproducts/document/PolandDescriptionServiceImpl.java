package dev.lukaszmichalak.regionalproducts.document;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class PolandDescriptionServiceImpl implements PolandDescriptionService {

  private final MessageSource messageSource;

  @Override
  public String getPl() {
    return messageSource.getMessage("voivodeships.poland.description", null, Locale.of("pl"));
  }

  @Override
  public String getEn() {
    return messageSource.getMessage("voivodeships.poland.description", null, Locale.ENGLISH);
  }
}
