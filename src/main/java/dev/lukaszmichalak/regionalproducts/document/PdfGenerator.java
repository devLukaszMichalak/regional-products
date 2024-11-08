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
  public void createForVoivodeship(GetDocumentCommand cmd) {
    System.out.println("pdf");
    
  }
  
  @Override
  public void createForAll(String lang) {
  
  }
}
