package dev.lukaszmichalak.regionalproducts.voivodeship.exception;

public class VoivodeshipNotFoundException extends RuntimeException {

  public VoivodeshipNotFoundException(Integer id) {
    super("Nie znaleziono produktu o id: " + id);
  }

  public VoivodeshipNotFoundException(String code) {
    super("Nie znaleziono produktu o kodzie: " + code);
  }
}
