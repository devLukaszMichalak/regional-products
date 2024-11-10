package dev.lukaszmichalak.regionalproducts.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class GenericErrorController {

  @GetMapping("/{lang}/error")
  public String getError() {
    return "error";
  }
}