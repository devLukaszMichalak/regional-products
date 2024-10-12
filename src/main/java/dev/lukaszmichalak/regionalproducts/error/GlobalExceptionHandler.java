package dev.lukaszmichalak.regionalproducts.error;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  protected String handleException() {
    var locale = LocaleContextHolder.getLocale();

    return "redirect:/" + locale.getLanguage() + "/error";
  }
}
