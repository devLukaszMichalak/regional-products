package dev.lukaszmichalak.regionalproducts.document.exception;

public class PdfContextCreationException extends RuntimeException {

  public PdfContextCreationException(Exception e) {
    super(e);
  }

  public PdfContextCreationException(String m) {
    super(m);
  }
}
