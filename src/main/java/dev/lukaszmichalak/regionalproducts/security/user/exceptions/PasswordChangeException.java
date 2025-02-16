package dev.lukaszmichalak.regionalproducts.security.user.exceptions;

public class PasswordChangeException extends RuntimeException {

  public PasswordChangeException(String message) {
    super(message);
  }
}
