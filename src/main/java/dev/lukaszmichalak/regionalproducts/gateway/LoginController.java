package dev.lukaszmichalak.regionalproducts.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequiredArgsConstructor
@RequestMapping("/{lang}/login")
class LoginController {

  @GetMapping()
  public String getLogin(Model model, @RequestParam(required = false) boolean hadError) {
    model.addAttribute("hadError", hadError);
    return "login";
  }
}
