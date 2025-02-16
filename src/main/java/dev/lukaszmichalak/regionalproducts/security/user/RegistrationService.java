package dev.lukaszmichalak.regionalproducts.security.user;

import jakarta.servlet.http.HttpSession;

public interface RegistrationService {

  boolean doesUserExists(String username);

  void register(String username, String password, HttpSession session);
}
