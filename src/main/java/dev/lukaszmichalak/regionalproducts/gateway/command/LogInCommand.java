package dev.lukaszmichalak.regionalproducts.gateway.command;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class LogInCommand {

  @Getter private final Authentication auth;

  LogInCommand(String username, String password) {
    this.auth = new UsernamePasswordAuthenticationToken(username, password);
  }
}
