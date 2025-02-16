package dev.lukaszmichalak.regionalproducts.locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Locale;
import lombok.NonNull;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

@Component("localeResolver")
class PathLocaleResolver implements LocaleResolver {
  
  @NonNull
  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String requestURI = request.getRequestURI();

    if (requestURI.contains("/pl/")) {
      var locale = Locale.of("pl");
      LocaleContextHolder.setLocale(locale);
      return locale;
    }

    if (requestURI.contains("/en/")) {
      var locale = Locale.ENGLISH;
      LocaleContextHolder.setLocale(locale);
      return locale;
    }

    return DefaultLocaleHolder.get();
  }

  @Override
  public void setLocale(@NonNull HttpServletRequest request, HttpServletResponse response, Locale locale) {
    throw new UnsupportedOperationException();
  }
}
