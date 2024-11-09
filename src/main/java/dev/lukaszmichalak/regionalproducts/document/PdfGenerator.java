package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.gateway.command.GetDocumentCommand;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("pdfGenerator")
@RequiredArgsConstructor
class PdfGenerator implements DocumentGenerator {

  private final ProductService productService;
  private final VoivodeshipService voivodeshipService;

  @Override
  public byte[] createForVoivodeship(GetDocumentCommand cmd) {
    return new byte[0];
  }

  @Override
  public byte[] createForAll(String lang) {
    return new byte[0];
  }
}
