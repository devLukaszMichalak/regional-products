package dev.lukaszmichalak.regionalproducts.product.exception;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException(Long id) {
    super("Nie znaleziono produktu o id: " + id);
  }

  public ProductNotFoundException(String name) {
    super("Nie znaleziono produktu o nazwie: " + name);
  }
}
