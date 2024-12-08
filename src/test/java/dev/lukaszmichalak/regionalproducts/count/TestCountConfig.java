package dev.lukaszmichalak.regionalproducts.count;

import dev.lukaszmichalak.regionalproducts.count.dto.CountDto;
import dev.lukaszmichalak.regionalproducts.product.ProductService;
import dev.lukaszmichalak.regionalproducts.product.TestProductConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.TestVoivodeshipConfig;
import dev.lukaszmichalak.regionalproducts.voivodeship.VoivodeshipService;
import java.util.List;

public class TestCountConfig {

  public static CountService countService() {

    ProductService productService = TestProductConfig.productService();
    VoivodeshipService voivodeshipService = TestVoivodeshipConfig.voivodeshipService();

    return new CountService() {
      @Override
      public List<CountDto> getCounts() {
        return voivodeshipService.getVoivodeships().stream()
            .map(
                voivodeship -> {
                  int count = productService.getProductsOfVoivodeship(voivodeship.id()).size();
                  return new CountDto(voivodeship.name(), count);
                })
            .toList();
      }

      @Override
      public long getTotalCount() {
        return productService.getProductsCount();
      }
    };
  }
}
