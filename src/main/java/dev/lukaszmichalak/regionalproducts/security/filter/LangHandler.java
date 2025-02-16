package dev.lukaszmichalak.regionalproducts.security.filter;

import dev.lukaszmichalak.regionalproducts.locale.DefaultLocaleHolder;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

abstract class LangHandler {

  String getLang(HttpServletRequest request) {
    return Optional.ofNullable(request.getParameter("lang"))
        .orElse(DefaultLocaleHolder.get().getLanguage());
  }
}
