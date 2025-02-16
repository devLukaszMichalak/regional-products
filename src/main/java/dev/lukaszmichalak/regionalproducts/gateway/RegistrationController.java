package dev.lukaszmichalak.regionalproducts.gateway;

import dev.lukaszmichalak.regionalproducts.security.user.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
class RegistrationController {

  private final RegistrationService registrationService;

  @GetMapping("/{lang}/register")
  public String showRegistrationForm(Model model) {
    return "register";
  }

  @PostMapping("/register")
  public String registerUser(
      Model model,
      HttpServletRequest request,
      @RequestParam("lang") String lang,
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("confirmPassword") String confirmPassword) {

    if (!password.equals(confirmPassword)) {
      if (lang.equals("en")) {
        model.addAttribute("error", "Passwords do not match!");
      } else {
        model.addAttribute("error", "Hasła nie są takie same!");
      }
      return "register";
    }

    if (registrationService.doesUserExists(username)) {
      if (lang.equals("en")) {
        model.addAttribute("error", "Username already exists!");
      } else {
        model.addAttribute("error", "Nazwa użytkownika jest już zajęta!");
      }
      return "register";
    }

    registrationService.register(username, password, request.getSession());

    return "redirect:/" + lang + "/voivodeships";
  }
}
