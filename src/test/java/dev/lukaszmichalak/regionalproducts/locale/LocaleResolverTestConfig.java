package dev.lukaszmichalak.regionalproducts.locale;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;

public class LocaleResolverTestConfig {

  @Bean
  LocaleResolver localeResolver() {
    return new PathLocaleResolver();
  }
}
