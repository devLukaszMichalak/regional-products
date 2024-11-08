package dev.lukaszmichalak.regionalproducts.document.exception;

public class DocumentGenerationException extends RuntimeException {

  public DocumentGenerationException(Exception e) {
    super(e);
  }
}
