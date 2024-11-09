package dev.lukaszmichalak.regionalproducts.document;

import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.TestProductConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.TestVoivodeshipConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;

public class TestDocxGeneratorConfig {

  public static DocumentGenerator docxGenerator() {

    ProductService productService = TestProductConfig.productService();
    VoivodeshipService voivodeshipService = TestVoivodeshipConfig.voivodeshipService();
    PolandDescriptionService polandDescriptionService = new TestPolandDescriptionService();

    return new DocxGenerator(productService, voivodeshipService, polandDescriptionService);
  }

  private static class TestPolandDescriptionService implements PolandDescriptionService {

    @Override
    public String getPl() {
      return "Test pl description";
    }

    @Override
    public String getEn() {
      return "Test en description";
    }
  }
}
