package dev.lukaszmichalak.regionalproducts.locale;

import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@ControllerAdvice
class LocaleControllerAdvice {

  @ModelAttribute
  public void addLang(
      Model model,
      HttpServletRequest request,
      @PathVariable(name = "lang", required = false) @Nullable String lang) {

    model.addAttribute("lang", Objects.requireNonNullElse(lang, "en"));

    String requestURI = request.getRequestURI();

    model.addAttribute("currentPlUrl", requestURI.replace("/en/", "/pl/"));
    model.addAttribute("currentEnUrl", requestURI.replace("/pl/", "/en/"));
  }
}
