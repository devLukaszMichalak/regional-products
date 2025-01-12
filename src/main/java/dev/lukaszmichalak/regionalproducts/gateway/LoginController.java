package dev.lukaszmichalak.regionalproducts.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequiredArgsConstructor
@RequestMapping("/{lang}/login")
class LoginController {

  private final AuthenticationManager authenticationManager;

  @GetMapping()
  public String getLogin(Model model, @RequestParam(required = false) boolean hadError) {
    model.addAttribute("hadError", hadError);
    return "login";
  }

  @PostMapping()
  public String login(
      @PathVariable String lang, @RequestParam String username, @RequestParam String password) {

    var auth = new UsernamePasswordAuthenticationToken(username, password);
    try {
      authenticationManager.authenticate(auth);
    } catch (AuthenticationException e) {
      return "redirect:/" + lang + "/login?hadError=true";
    }

    return "redirect:/" + lang + "/voivodeships";
  }
}
