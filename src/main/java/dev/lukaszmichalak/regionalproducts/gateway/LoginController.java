package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.gateway.command.LogInCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
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
  public String login(@PathVariable String lang, @ModelAttribute LogInCommand cmd) {
  
    try {
      Authentication authenticated = authenticationManager.authenticate(cmd.getAuth());
      SecurityContextHolder.getContext().setAuthentication(authenticated);
    } catch (AuthenticationException e) {
      return "redirect:/" + lang + "/login?hadError=true";
    }

    return "redirect:/" + lang + "/voivodeships";
  }
}
