package dev.lukaszmichalak.regionalproducts.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  protected String handleException(Exception error) {
    var locale = LocaleContextHolder.getLocale();
    log.error(error.getMessage(), error);
    return "redirect:/" + locale.getLanguage() + "/error";
  }
}
